package com.tello;

import com.tello.connection.impl.TelloCamServer;
import com.tello.connection.impl.TelloController2;
import com.tello.connection.impl.TelloStatusServer;

public class Tello2 {
    private TelloController2 controller;
    private TelloStatusServer statusListener;
    private TelloCamServer camListener;

    public Tello2() {
        this.statusListener = new TelloStatusServer();
        this.camListener = new TelloCamServer();
        this.controller = new TelloController2();
    }

    public void shutdownGracefully() {
        this.controller.close();
        this.statusListener.close();
        this.camListener.close();
    }

    public TelloController2 getController() {
        return this.controller;
    }
}
