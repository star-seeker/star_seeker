package seek.pattern.bridgepattern;

public class GreenShape implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("GreenShape.drawCircle: radius=" + radius + ", x=" + x + ", y=" + y);
    }

    @Override
    public void drawSquare(int radius, int x, int y) {
        System.out.println("GreenShape.drawSquare: radius=" + radius + ", x=" + x + ", y=" + y);
    }
}
