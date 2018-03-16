package seek.pattern.abstractfactorypattern;

import seek.pattern.factorypattern.Shape;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color blue = colorFactory.getColor("blue");
        blue.fill();

    }
}
