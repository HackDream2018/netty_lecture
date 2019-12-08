package test.designpattern.action.strategy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/12/8
 */
public abstract class Duck {

    /**
     * 飞行行为策略接口
     */
    protected FlyBehavior flyBehavior;

    /**
     * 游泳行为策略接口
     */
    protected SwimBehavior swimBehavior;

    /**
     * 展示鸭子信息
     */
    abstract void display();

}
