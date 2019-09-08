package test.designpattern.structure.decorator;

import java.math.BigDecimal;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/8
 */
public class Coffee extends AbsDrink {

    @Override
    public BigDecimal calculateCost() {
        return super.getPrice();
    }

}
