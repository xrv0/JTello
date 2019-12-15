package com.tello.connection.impl;


import com.tello.connection.Server;

public class TelloStatusServer extends Server {
    public static final int TELLO_STATUS_LISTEN_PORT = 8890;

    public TelloStatusServer() {
        super(TELLO_STATUS_LISTEN_PORT, 1024);
    }

    @Override
    protected void handle(byte[] message) {
        System.out.println(new String(message));
    }
}
