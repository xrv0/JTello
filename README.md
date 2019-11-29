# JTello

A lightweight and simple to use java library for communicating and controlling a [DJI Tello Drone](https://store.dji.com/de/product/tello)

## Installation

Download the library and include it in your project.


## Usage

```java
Tello myTello = new Tello();
TelloController myTelloController = myTello.getController();
        
myTelloController.takeoff();
myTelloController.rotate(90);
myTelloController.land();

myTello.shutdownGracefully();
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[GNU GPL3](https://www.gnu.org/licenses/gpl-3.0.de.html)
