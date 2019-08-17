package test.designpattern.create.factory.simple;

import test.designpattern.create.factory.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/10
 */
public class BeiJingOrderPizza {

    Pizza pizza = null;

    public BeiJingOrderPizza() {
        setFactory();
    }

    private void setFactory() {
        do {
            pizza = SimpleFacotry.createPizza(getPizzaType());
            if(null != pizza) {
                // 输出制作过程
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("未生产此类披萨, 关店");
            }
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
