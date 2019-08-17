package test.designpattern.create.singleton;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/10
 */
public class TestMethod {

    public static void main(String[] args)throws Exception {
        for(int i = 0; i < 100 ; i++) {
            new Thread(() -> {
                EnumSingleton singleton1 = EnumSingleton.SINGLETON;
                EnumSingleton singleton2 = EnumSingleton.SINGLETON;
                System.out.println(singleton1 == singleton2); // true
                System.out.println(singleton1.hashCode() == singleton2.hashCode());// true
                if(singleton1 != singleton2) {
                    System.out.println("出现多个实例啊啊啊啊");
                }
            }).start();
        }

    }

    enum EnumSingleton {
        SINGLETON
    }
}
