package test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    @Test
    public void testMethod() {
        BigDecimal a = BigDecimal.valueOf(10);
        BigDecimal b = BigDecimal.valueOf(3);
         System.out.println(a.divide(b, 2, BigDecimal.ROUND_HALF_UP));
    }
   

}