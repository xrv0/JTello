package test.example;

import com.tello.Tello;
import com.tello.connection.impl.TelloController;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Tello myTello = new Tello();
        TelloController myTelloController = myTello.getController();

        myTelloController.takeoff();
        System.out.println(myTelloController.getBattery());
        Thread.sleep(1000);
        myTelloController.land();
        myTello.shutdownGracefully();
    }
}
