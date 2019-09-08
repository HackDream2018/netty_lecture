package test.designpattern.structure.decorator;

import java.math.BigDecimal;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/8
 */
public class DecafCoffee extends Coffee {

    public DecafCoffee() {
        this.setDescription(" 无因咖啡 ");
        this.setPrice(BigDecimal.valueOf(4.0));
    }

}
