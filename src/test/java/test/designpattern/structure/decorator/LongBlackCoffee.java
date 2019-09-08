package test.designpattern.structure.decorator;

import java.math.BigDecimal;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/8
 */
public class LongBlackCoffee extends Coffee {

    public LongBlackCoffee() {
        this.setDescription(" 澳洲黑咖啡 ");
        this.setPrice(BigDecimal.valueOf(8.0));
    }

}
