package test.designpattern.action.strategy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 能飞行且飞的很好策略
 * @date: 2019/12/8
 */
public class GoodFlyBehavior implements FlyBehavior{

    @Override
    public void fly() {
         System.out.println("能飞行且飞的很好");
    }
    
}
