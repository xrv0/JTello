package test.example;

import com.tello.Tello;
import com.tello.connection.impl.TelloController;

public class Main {
    public static void main(String args[]) {
        Tello tello = new Tello();
        TelloController controller = tello.getController();
        controller.takeoff();
        controller.emergency();
        System.out.println(controller.getBattery());
        tello.exit();
    }
}
