package com.tello;

import com.tello.connection.impl.TelloCamServer;
import com.tello.connection.impl.TelloController;
import com.tello.connection.impl.TelloStatusServer;

public class Tello {
    private TelloController controller;
    private TelloStatusServer statusListener;
    private TelloCamServer camListener;

    public Tello() {
        this.statusListener = new TelloStatusServer();
        this.camListener = new TelloCamServer();
        this.controller = new TelloController();
    }

    public void shutdownGracefully() {
        this.controller.close();
        this.statusListener.close();
        this.camListener.close();
    }

    public TelloController getController() {
        return this.controller;
    }
}
