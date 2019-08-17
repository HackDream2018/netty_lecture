package test.designpattern.create.factory.simple;

import test.designpattern.create.factory.CheesePizza;
import test.designpattern.create.factory.GreekPizza;
import test.designpattern.create.factory.PepperPizza;
import test.designpattern.create.factory.Pizza;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/17
 */
public class SimpleFacotry {

    public static Pizza createPizza(String orderType) {
        System.out.println("使用简单工厂模式");
        Pizza pizza = null;
        if("cheese".equals(orderType)) {
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        }else if("pepper".equals(orderType)) {
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }else if("greek".equals(orderType)) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        }
        return pizza;
    }

}
