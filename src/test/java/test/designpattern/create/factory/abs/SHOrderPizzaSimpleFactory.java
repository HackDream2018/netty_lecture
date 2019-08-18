package test.designpattern.create.factory.abs;


import test.designpattern.create.factory.Pizza;
import test.designpattern.create.factory.method.SHCheesePizza;
import test.designpattern.create.factory.method.SHPepperPizza;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/10
 */
public class SHOrderPizzaSimpleFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String pizzaType) {
        Pizza pizza = null;
        if(pizzaType.equals("cheese")) {
            pizza = new SHCheesePizza();
            pizza.setName("上海的奶酪披萨");
        }else if (pizzaType.equals("pepper")){
            pizza = new SHPepperPizza();
            pizza.setName("上海的胡椒披萨");
        }
        return pizza;
    }

}
