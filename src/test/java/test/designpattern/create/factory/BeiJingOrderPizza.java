package test.designpattern.create.factory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/10
 */
public class BeiJingOrderPizza {

    // 披萨订货
    public BeiJingOrderPizza() {
        Pizza pizza = null;
        String pizzaType = null;
        do {
            pizzaType = getPizzaType();
            if("cheese".equals(pizzaType)) {
                pizza = new CheesePizza();
                pizza.setName("奶酪披萨");
            }else if("pepper".equals(pizzaType)) {
                pizza = new PepperPizza();
                pizza.setName("胡椒披萨");
            }else if("greek".equals(pizzaType)) {
                pizza = new GreekPizza();
                pizza.setName("希腊披萨");
            }else {
                System.out.println("未生产此类披萨, 关店");
                break;
            }
            // 输出制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
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
