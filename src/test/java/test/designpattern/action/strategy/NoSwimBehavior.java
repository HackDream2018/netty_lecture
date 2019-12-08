package test.designpattern.action.strategy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 不能游泳策略
 * @date: 2019/12/8
 */
public class NoSwimBehavior implements SwimBehavior{

    @Override
    public void swim() {
         System.out.println("不能游泳");
    }
    
}
