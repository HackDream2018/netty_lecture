package test.designpattern.action.strategy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:玩具鸭 , 不能飞行不能自己游泳
 * @date: 2019/12/8
 */
public class ToyDuck extends Duck {

    public ToyDuck() {
        super.flyBehavior = new NoFlyBehavior();
        super.swimBehavior = new NoSwimBehavior();
    }

    @Override
    void display() {
         System.out.println("玩具鸭");
    }
}
