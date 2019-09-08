package test.designpattern.structure.decorator;

import java.math.BigDecimal;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/8
 */
public class Decorator extends AbsDrink {

    private AbsDrink drink;

    public Decorator(AbsDrink drink) {
        this.drink = drink;
    }

    @Override
    public BigDecimal calculateCost() {
        // 配料单价 + 咖啡单价
        return this.getPrice().add(drink.calculateCost());
    }

    @Override
    public String getDescription() {
        // super.getDescription()/super.getPrice()为当前配料信息
        return super.getDescription() + super.getPrice() + " && " + drink.getDescription();
    }

}
