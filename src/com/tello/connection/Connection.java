package com.tello.connection;

import com.tello.logger.Logger;
import java.io.IOException;
import java.net.*;

public class Connection {
    private final String host;
    private final short port;
    private InetAddress address;
    private DatagramSocket socket;

    public Connection(String host, short port) {
        this.host = host;
        this.port = port;

        try {
            this.address = InetAddress.getByName(host);
            this.socket = new DatagramSocket();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.connect();
    }

    /**
     * Close connection
     * THIS METHODS NEEDS TO BE CALLED WHEN EXITING
     */
    public void close() {
        socket.close();
    }

    private void connect() {
        this.socket.connect(this.address, this.port);
    }

    public String sendAndReceiveCommand(String command, int length) {
        this.sendCommand(command);
        return this.receiveMessage(length);
    }

    public String sendAndReceiveCommand(String command) {
        this.sendCommand(command);
        return this.receiveMessage(command.getBytes().length).replace(" ", "");
    }

    public boolean confirmationCommand(String command) {
        String response = sendAndReceiveCommand(command);
        System.out.println(response.length());
        if(response.equalsIgnoreCase("ok")) {
            return true;
        }
        return false;
    }

    public void sendCommand(String command) {
        if(this.socket.isConnected()) {
            if(command != null) {
                if(command.length() > 0) {
                    final byte[] data = command.getBytes();
                    final DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
                    try {
                        socket.send(packet);
                    } catch (IOException e) {
                        Logger.INSTANCE.error("Error when sending packet" + host + ":" + port, e);
                    }
                }else {
                    Logger.INSTANCE.error("Command is empty!");
                }
            }else {
                Logger.INSTANCE.error("Command is null!");
            }
        }else {
            Logger.INSTANCE.error("UDP Socket is not connected! " + host + ":" + port);
        }
    }

    public String receiveMessage() {
        return this.receiveMessage(1518);
    }

    public String receiveMessage(int length) {
        byte[] data = new byte[length];
        final DatagramPacket packet = new DatagramPacket(data, data.length);
        try {
            socket.receive(packet);
            final String ret = new String(packet.getData());
            System.out.println(ret);
            return ret;
        } catch (IOException e) {
            Logger.INSTANCE.error("Error when receiving packet" + host + ":" + port, e);
        }
        return null;
    }
}
