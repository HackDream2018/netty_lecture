package test.designpattern.action.strategy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 能游泳且游的很好策略
 * @date: 2019/12/8
 */
public class GoodSwimBehavior implements SwimBehavior{

    @Override
    public void swim() {
         System.out.println("能游泳且游的很好");
    }
    
}
