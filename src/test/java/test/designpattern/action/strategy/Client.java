package test.designpattern.action.strategy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/12/8
 */
public class Client {

    public static void main(String[] args) {
        Duck wildDuck = new WildDuck();
        wildDuck.flyBehavior.fly();
        wildDuck.swimBehavior.swim();
        System.out.println("-----------------");
        Duck rearingDuck = new RearingDuck();
        rearingDuck.flyBehavior.fly();
        rearingDuck.swimBehavior.swim();
        System.out.println("-----------------");
        Duck toyDuck = new ToyDuck();
        toyDuck.flyBehavior.fly();
        toyDuck.swimBehavior.swim();
    }

}
