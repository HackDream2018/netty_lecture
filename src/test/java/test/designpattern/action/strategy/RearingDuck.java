package test.designpattern.action.strategy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 饲养鸭, 不能飞
 * @date: 2019/12/8
 */
public class RearingDuck extends Duck {

    public RearingDuck() {
        super.flyBehavior = new BadFlyBehavior();
        super.swimBehavior = new BadSwimBehavior();
    }

    @Override
    void display() {
         System.out.println("饲养鸭");
    }
}
