package test.example;

import com.tello.Tello;
import com.tello.connection.impl.TelloController;

public class Main {
    public static void main(String args[]) {
        Tello myTello = new Tello();
        TelloController myTelloController = myTello.getController();

        myTelloController.takeoff();
        myTelloController.emergency();
        System.out.println(myTelloController.getBattery());
        
        myTello.exit();
    }
}
