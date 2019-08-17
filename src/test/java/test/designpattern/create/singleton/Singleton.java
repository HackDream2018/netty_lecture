package test.designpattern.create.singleton;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/10
 */
public class Singleton {
    // 不让外部通过new的方式创建对象
    private void Singleton() {}
    /**
     * 只有当外部类调用内部类时会通过JVM的类加载器实例化内部类对象, 类加载器创建对象是线程安全的
     */
    private static class InnerSingletonInstance {
        private static final Singleton SINGLETON = new Singleton();
    }

    public static Singleton getInstance() {
        return InnerSingletonInstance.SINGLETON;
    }

}
