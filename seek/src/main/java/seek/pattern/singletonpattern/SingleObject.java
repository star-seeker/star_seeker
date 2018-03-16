package seek.pattern.singletonpattern;

import org.jetbrains.annotations.Contract;

public class SingleObject {

    /**
     * 饿汉式：一般情况使用
     */
    // 创建SingleObject的一个对象
    private static SingleObject instance = new SingleObject();

    private SingleObject(){};

    // 获取唯一可用对象
    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("hello world.");
    }

    /**
     * 登记式/静态内部类：要明确实现lazy loading效果时使用
     */
    private static class SingletonHolder {
        private static final SingleObject INSTANCE = new SingleObject();
    }
    // private SingleObject(){};
    public static final SingleObject getInstance2() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 枚举：涉及到反序列化创建对象时使用
     */
    public enum Singleton {
        INSTANCE;
        public void method() {

        }
    }

    /**
     * 双重校验锁
     */
    private volatile static SingleObject singleton;
    // private SingleObject(){};
    public static  SingleObject getSingleton() {
        if (singleton == null) {
            synchronized (SingleObject.class) {
                if (singleton == null) {
                    singleton = new SingleObject();
                }
            }
        }
        return singleton;
    }
}
