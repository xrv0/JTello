package test;

import com.tello.connection.impl.TelloSendResponseConnection;

public class Main {
    public static void main(String args[]) {
        TelloSendResponseConnection connection = new TelloSendResponseConnection();
        connection.enterSDKMode();
        //System.out.println(connection.takeoff());
        System.out.println(connection.sendAndReceiveCommand("temp?"));
        connection.close();
    }
}
