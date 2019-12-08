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
        
         System.out.println(new BigDecimal("10000").multiply(BigDecimal.valueOf(5)).divide(BigDecimal.valueOf(5)).toString());
        
    }


}