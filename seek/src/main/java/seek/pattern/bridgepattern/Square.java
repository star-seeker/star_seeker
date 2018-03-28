package seek.pattern.bridgepattern;

public class Square extends Shape {

    private int radius, x, y;

    public Square(int radius, int x, int y, DrawAPI drawAPI) {
        super(drawAPI);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawAPI.drawSquare(radius, x, y);
    }
}
