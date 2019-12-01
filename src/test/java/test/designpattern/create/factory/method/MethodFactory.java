package test.designpattern.create.factory.method;

import test.designpattern.create.factory.Pizza;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 客户端创建MethodFactory的子类对象时, MethodFactory会初始化构造方法
 *               又createPizza()由子类对象实现, 所以执行的是子类对象的createPizza();
 * @date: 2019/8/17
 */
public abstract class MethodFactory {

    // 让其子工厂实现具体细节
    abstract Pizza createPizza();

    public MethodFactory() {
        Pizza pizza = createPizza();
        // 输出制作过程
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }
}
