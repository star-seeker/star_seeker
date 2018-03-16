package seek.pattern.abstractfactorypattern;

import seek.pattern.factorypattern.Circle;
import seek.pattern.factorypattern.Rectangle;
import seek.pattern.factorypattern.Shape;
import seek.pattern.factorypattern.Square;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if ("circle".equalsIgnoreCase(shapeType)) {
            return new Circle();
        } else if ("square".equalsIgnoreCase(shapeType)) {
            return new Square();
        } else if ("rectangle".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        }
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        return null;
    }
}
