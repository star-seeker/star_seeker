package seek.pattern.abstractfactorypattern;

import seek.pattern.factorypattern.Shape;

public abstract class AbstractFactory {
    public abstract Shape getShape (String shapeType);
    public  abstract Color getColor(String colorType);
}
