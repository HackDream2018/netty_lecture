package test.designpattern.create.factory.method;

import test.designpattern.create.factory.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/10
 */
public class SHOrderPizzaSimpleFactory extends MethodFactory{

    @Override
    Pizza createPizza() {
        String pizzaType = getPizzaType();
        Pizza pizza = null;
        if(pizzaType.equals("cheese")) {
            pizza = new SHCheesePizza();
            pizza.setName("上海的奶酪披萨");
        }else {
            pizza = new SHPepperPizza();
            pizza.setName("上海的胡椒披萨");
        }
        return pizza;
    }

    private String getPizzaType() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入要购买的披萨种类: ");
            return reader.readLine();
        }catch (Exception e) {
            return "";
        }
    }

}
