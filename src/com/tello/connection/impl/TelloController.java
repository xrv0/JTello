package com.tello.connection.impl;

import com.tello.connection.Connection;

/**
 * Sends and receives data
 */
public class TelloController extends Connection {
    public static final String host = "192.168.10.1";
    public static final short port = 8889;

    public TelloController() {
        super(host, port);
    }

    /**
     * entry SDK mode
     * @return was successful
     */
    public boolean enterSDKMode() {
        return super.confirmationCommand("command");
    }

    /**
     * Tello auto takeoff
     * @return was successful
     */
    public boolean takeoff() {
        return super.confirmationCommand("takeoff");
    }

    /**
     * Tello auto land
     * @return was successful
     */
    public boolean land() {
        return super.confirmationCommand("land");
    }

    /**
     * Enable video stream on
     * @return was successful
     */
    public boolean enableVideoStream() {
        return super.confirmationCommand("streamon");
    }

    /**
     * Disable video stream on
     * @return was successful
     */
    public boolean disableVideoStream() {
        return super.confirmationCommand("streamoff");
    }

    /**
     * Stop all motors immediately
     * @return
     */
    public boolean emergency() {
        return super.confirmationCommand("emergency");
    }

    /**
     * Fly up
     * @param cm distance in cm 20-500
     * @return was successful
     */
    public boolean flyUp(short cm) {
        return super.confirmationCommand("up " + cm);
    }

    /**
     * Fly up
     * @param cm distance in cm 20-500
     * @return was successful
     */
    public boolean flyDown(short cm) {
        return super.confirmationCommand("down " + cm);
    }

    /**
     * Fly left
     * @param cm distance in cm 20-500
     * @return was successful
     */
    public boolean flyLeft(short cm) {
        return super.confirmationCommand("left " + cm);
    }

    /**
     * Fly right
     * @param cm distance in cm 20-500
     * @return was successful
     */
    public boolean flyRight(short cm) {
        return super.confirmationCommand("right " + cm);
    }

    /**
     * Fly forward
     * @param cm distance in cm 20-500
     * @return was successful
     */
    public boolean flyForward(short cm) {
        return super.confirmationCommand("forward " + cm);
    }

    /**
     * Fly back
     * @param cm distance in cm 20-500
     * @return was successful
     */
    public boolean flyBackward(short cm) {
        return super.confirmationCommand("back " + cm);
    }

    /**
     * Rotate the drone
     * @param degree -360 - 360
     * @return
     */
    public boolean rotate(float degree) {
        if(degree > 0) {
            return super.confirmationCommand("cw " + (int) (degree * 10));
        }else {
            return super.confirmationCommand("ccw " + Math.abs((int) (degree * 10)));
        }
    }

    /**
     * Tello flyto x y z in speed
     * @param x 20 - 500
     * @param y 20 - 500
     * @param z 20 - 500
     * @param speed 10 - 100 (cm/s)
     * @return was successful
     */
    public boolean go(int x, int y, int z, int speed) {
        return super.confirmationCommand("go " + x + " " + y + " " + z + " " + speed);
    }

    /**
     * set speed
     * @param speed cm / s
     * @return was successful
     */
    public boolean setSpeed(short speed) {
        return super.confirmationCommand("speed " + speed);
    }

    /**
     * set wifi ssid password
     */
    public boolean setWifiPassword(String password) {
        return super.confirmationCommand("wifi ssid " + password);
    }

    public int getBattery() {
        return 0;
    }
}
