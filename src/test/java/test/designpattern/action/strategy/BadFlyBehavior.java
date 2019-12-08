package test.designpattern.action.strategy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 飞的很差策略
 * @date: 2019/12/8
 */
public class BadFlyBehavior implements FlyBehavior{

    @Override
    public void fly() {
         System.out.println("飞的很差");
    }
    
}
