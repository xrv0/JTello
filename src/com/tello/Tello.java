package com.tello;

import com.tello.connection.impl.TelloController;

public class Tello {
    private TelloController controller;

    public Tello() {
        this.controller = new TelloController();
        this.controller.enterSDKMode();
    }

    /**
     * This needs to be called when exiting
     * Closes the UDP Connection
     */
    public void exit() {
        this.controller.close();
    }

    public TelloController getController() {
        return this.controller;
    }
}
