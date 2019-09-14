package test.designpattern.structure.facade;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 投影仪
 * @date: 2019/9/14
 */
public class Projects {

    private static Projects instance = new Projects();

    private Projects() {}

    public static Projects getInstance() {
        return instance;
    }

    public void on() {
         System.out.println("打开投影仪");
    }

    public void focus() {
        System.out.println("聚焦投影仪");
    }

    public void off() {
        System.out.println("关闭投影仪");
    }

}
