package test.designpattern.structure.decorator;

import java.math.BigDecimal;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/8
 */
public class Sugar extends Decorator {

    public Sugar(AbsDrink drink) {
        super(drink);
        this.setDescription(" 白糖 ");
        this.setPrice(BigDecimal.valueOf(2));
    }

}
