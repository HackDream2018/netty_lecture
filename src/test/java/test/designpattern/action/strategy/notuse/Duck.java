package test.designpattern.action.strategy.notuse;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/12/8
 */
public abstract class Duck {
    /**
     * 展示鸭子信息
     */
    abstract void display();

    public void swim() {
        System.out.println("鸭子游泳");
    }

    public void fly() {
        System.out.println("鸭子飞");
    }
}
