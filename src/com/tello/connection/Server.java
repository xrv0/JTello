package com.tello.connection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public abstract class Server extends Thread {
    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[2048];
    private int port;

    public Server(int port, int length) {
        this.port = port;
        this.buf = new byte[length];
    }

    public void run() {
        running = true;

        while (running) {
            try {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                this.handle(packet.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }

    protected abstract void handle(byte[] message);

    public void close() {
        this.running = false;
    }
}
