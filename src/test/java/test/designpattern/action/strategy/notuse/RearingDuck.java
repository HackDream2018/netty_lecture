package test.designpattern.action.strategy.notuse;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 饲养鸭, 不能飞
 * @date: 2019/12/8
 */
public class RearingDuck extends Duck {
    @Override
    void display() {
         System.out.println("饲养鸭");
    }

    /**
     * 由于饲养鸭不能飞行, 所以要重写父类鸭子的特性
     */
    @Override
    public void fly() {
         System.out.println("饲养鸭不能飞行");
    }
}
