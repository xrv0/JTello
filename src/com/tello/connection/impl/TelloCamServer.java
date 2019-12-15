package com.tello.connection.impl;

import com.tello.connection.Server;
import org.jcodec.codecs.h264.H264Decoder;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import java.nio.ByteBuffer;

public class TelloCamServer extends Server {
    public static final int TELLO_CAM_LISTEN_PORT = 11111;
    private H264Decoder decoder;

    public TelloCamServer() {
        super(TELLO_CAM_LISTEN_PORT, 2048);
        this.decoder = new H264Decoder();
    }

    @Override
    protected void handle(byte[] message) {
        Picture out = Picture.create(1920, 1088, ColorSpace.YUV420); // Allocate output frame of max size
        Picture real = decoder.decodeFrame(ByteBuffer.wrap(message), out.getData());
        System.out.println(real.getWidth() +  " : " + real.getHeight());
    }
}
