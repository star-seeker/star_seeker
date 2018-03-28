package seek.pattern.bridgepattern;

public class RedShape implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("RedShape.drawCircle: radius=" + radius + ", x=" + x + ", y=" + y);
    }

    @Override
    public void drawSquare(int radius, int x, int y) {
        System.out.println("RedShape.drawSquare: radius=" + radius + ", x=" + x + ", y=" + y);
    }
}
