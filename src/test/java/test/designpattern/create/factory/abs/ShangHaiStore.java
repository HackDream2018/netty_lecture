package test.designpattern.create.factory.abs;


/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/10
 */
public class ShangHaiStore {

    public static void main(String[] args) {
        new OrderPizza(new SHOrderPizzaSimpleFactory());
    }

}