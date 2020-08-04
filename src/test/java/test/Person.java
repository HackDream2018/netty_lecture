package test;

import java.math.BigDecimal;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/6/22
 */
public class Person {

    private BigDecimal sale = BigDecimal.ONE;
    private String sale2;
    private BigDecimal sale3 = BigDecimal.ONE;

    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }

    public String getSale2() {
        return sale2;
    }

    public void setSale2(String sale2) {
        this.sale2 = sale2;
    }

    public BigDecimal getSale3() {
        return sale3;
    }

    public void setSale3(BigDecimal sale3) {
        this.sale3 = sale3;
    }
}
