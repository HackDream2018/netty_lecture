package test.designpattern.structure.facade;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 灯光
 * @date: 2019/9/14
 */
public class Lights {

    private Lights() {}

    private static class SingleInstanceClass {
        private static final Lights INSTANCE = new Lights();
    }

    public static Lights getInstance() {
        return SingleInstanceClass.INSTANCE;
    }
    
    public void on() {
         System.out.println("打开灯光");
    }

    public void dim() {
        System.out.println("调暗灯光");
    }

    public void bright() {
        System.out.println("调亮灯光");
    }

    public void off() {
         System.out.println("关闭灯光");
    }

}
