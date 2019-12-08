package test.designpattern.action.strategy.notuse;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:玩具鸭 , 不能飞行不能自己游泳
 * @date: 2019/12/8
 */
public class ToyDuck extends Duck {
    @Override
    void display() {
         System.out.println("玩具鸭");
    }

    /**
     * 需要重写
     */
    @Override
    public void swim() {
        System.out.println("玩具鸭不能游泳");
    }

    /**
     * 需要重写
     */
    @Override
    public void fly() {
         System.out.println("玩具鸭不能飞行");
    }
}
