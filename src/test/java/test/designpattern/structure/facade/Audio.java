package test.designpattern.structure.facade;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 音响
 * @date: 2019/9/14
 */
public class Audio {

    private Audio() {}

    private static class SingleInstanceClass {
        private static final Audio INSTANCE = new Audio();
    }

    public static Audio getInstance() {
        return SingleInstanceClass.INSTANCE;
    }
    
    public void on() {
         System.out.println("打开音响");
    }
    
    public void off() {
         System.out.println("关闭音响");
    }

}
