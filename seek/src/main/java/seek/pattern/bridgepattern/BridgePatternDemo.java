package seek.pattern.bridgepattern;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(10, 5, 5, new RedShape());
        redCircle.draw();

        Shape greenCircle = new Circle(10, 10, 10, new GreenShape());
        greenCircle.draw();

        Shape redSquare = new Square(10, 5, 5, new RedShape());
        redSquare.draw();

        Shape greenSquare = new Square(10, 10, 10, new GreenShape());
        greenSquare.draw();
    }
}
