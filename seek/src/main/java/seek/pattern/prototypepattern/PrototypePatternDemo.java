package seek.pattern.prototypepattern;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        // 使用ShapeCache获取存储在Hashtable中的形状的克隆
        ShapeCache.loadCache();

        Shape shape = ShapeCache.getShape("1");
        System.out.println("shape:" + shape.getType());

        Shape shape1 = ShapeCache.getShape("2");
        System.out.println("shape:" + shape1.getType());

        Shape shape2 = ShapeCache.getShape("3");
        System.out.println("shape:" + shape2.getType());
    }
}
