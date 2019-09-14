package test.designpattern.structure.facade;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 爆米花
 * @date: 2019/9/14
 */
public class Popcorn {

    private Popcorn() {}

    private static class SingleInstanceClass {
        private static final Popcorn INSTANCE = new Popcorn();
    }

    public static Popcorn getInstance() {
        return SingleInstanceClass.INSTANCE;
    }
    
    public void on() {
         System.out.println("打开爆米花机");
    }

    public void takePopcorn() {
        System.out.println("取出爆米花");
    }
    
    public void off() {
         System.out.println("关闭爆米花机");
    }

}
