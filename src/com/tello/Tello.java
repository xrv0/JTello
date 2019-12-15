package com.tello;

import com.tello.connection.impl.TelloController;
import com.tello.logger.Logger;

public class Tello {
    public static final String TELLO_HOSTNAME = "192.168.10.1";
    public static final int TELLO_PORT = 8889;

    private TelloController controller;

    public Tello() {
        if(isReachable()) {
            this.controller = new TelloController(TELLO_HOSTNAME, TELLO_PORT);
            this.controller.enterSDKMode();
        }else {
            Logger.INSTANCE.error("Tello is not reachable or took too long to respond(3000)");
        }
    }

    /**
     * This needs to be called when exiting
     * Closes the UDP Connection
     */
    public void exit() {
        this.controller.close();
    }

    /**
     * @return Tello Controller instance
     */
    public TelloController getController() {
        return this.controller;
    }

    private boolean isReachable() {
        return true;
        /*
        try {
            InetAddress address = InetAddress.getByName("192.168.1.103");
            return address.isReachable(3000);
        } catch (UnknownHostException e) {
            Logger.INSTANCE.error("An error occured when checking the reachability ", e);
        } catch (IOException e) {
            Logger.INSTANCE.error("Unknown host", e);
        }
        return false;*/
    }
}
