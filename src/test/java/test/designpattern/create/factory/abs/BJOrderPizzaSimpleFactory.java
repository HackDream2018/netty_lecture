package test.designpattern.create.factory.abs;


import test.designpattern.create.factory.Pizza;
import test.designpattern.create.factory.method.BJCheesePizza;
import test.designpattern.create.factory.method.BJPepperPizza;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/10
 */
public class BJOrderPizzaSimpleFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String pizzaType) {
        Pizza pizza = null;
        if (pizzaType.equals("cheese")) {
            pizza = new BJCheesePizza();
            pizza.setName("北京的奶酪披萨");
        }else if(pizzaType.equals("pepper")){
            pizza = new BJPepperPizza();
            pizza.setName("北京的胡椒披萨");
        }
        return pizza;
    }

}
