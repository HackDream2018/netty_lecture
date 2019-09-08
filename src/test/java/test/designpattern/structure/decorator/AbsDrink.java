package test.designpattern.structure.decorator;

import java.math.BigDecimal;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/8
 */
public abstract class AbsDrink {

    private String description;

    private BigDecimal price;

    public abstract BigDecimal calculateCost();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
