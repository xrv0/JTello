import com.tello.Tello2;
import com.tello.connection.impl.TelloController2;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Tello2 myTello = new Tello2();
        TelloController2 myTelloController = myTello.getController();
        myTelloController.enableVideoStream();
        myTello.shutdownGracefully();
    }
}
