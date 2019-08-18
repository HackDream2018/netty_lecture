package test.designpattern.create.factory.abs;

import test.designpattern.create.factory.Pizza;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/18
 */
public interface AbsFactory {

    // 让其子工厂实现具体细节
     Pizza createPizza(String pizzaType);

}
