package seek.pattern.abstractfactorypattern;

import seek.pattern.factorypattern.Shape;

public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        if ("red".equalsIgnoreCase(colorType)) {
            return new Red();
        } else if ("green".equalsIgnoreCase(colorType)) {
            return new Green();
        } else if ("blue".equalsIgnoreCase(colorType)) {
            return new Blue();
        }
        return null;
    }
}
