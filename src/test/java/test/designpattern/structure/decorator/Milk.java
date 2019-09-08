package test.designpattern.structure.decorator;

import java.math.BigDecimal;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/8
 */
public class Milk extends Decorator {

    public Milk(AbsDrink drink) {
        super(drink);
        this.setDescription(" 牛奶 ");
        this.setPrice(BigDecimal.valueOf(5.0));
    }

}
