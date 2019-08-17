package test.designpattern.create.factory.method;

import test.designpattern.create.factory.Pizza;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/17
 */
public abstract class MethodFactory {

    // 让其子工厂实现具体细节
    abstract Pizza createPizza();

    public MethodFactory() {
        do {
            Pizza pizza = createPizza();
            // 输出制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }
}
