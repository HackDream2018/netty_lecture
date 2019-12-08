package test.designpattern.action.strategy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 不能飞行策略
 * @date: 2019/12/8
 */
public class NoFlyBehavior implements FlyBehavior{

    @Override
    public void fly() {
         System.out.println("不能飞行");
    }

}
