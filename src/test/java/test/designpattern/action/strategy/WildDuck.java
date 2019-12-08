package test.designpattern.action.strategy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 野鸭能游泳能飞
 * @date: 2019/12/8
 */
public class WildDuck extends Duck {

    public WildDuck() {
        super.flyBehavior = new GoodFlyBehavior();
        super.swimBehavior = new GoodSwimBehavior();
    }

    @Override
    void display() {
         System.out.println("野鸭子");
    }
}
