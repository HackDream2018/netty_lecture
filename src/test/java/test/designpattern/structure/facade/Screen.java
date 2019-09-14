package test.designpattern.structure.facade;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 影屏
 * @date: 2019/9/14
 */
public class Screen {

    private Screen(){}

    private static class SingletonInstanceClass {
        private static final Screen INSTANCE = new Screen();
    }

    public static Screen getInstance() {
        return SingletonInstanceClass.INSTANCE;
    }

    public void down() {
         System.out.println("降下屏幕");
    }

    public void up() {
        System.out.println("升起屏幕");
    }

}
