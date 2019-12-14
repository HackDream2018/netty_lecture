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
        
         /*System.out.println(new BigDecimal("10000").multiply(BigDecimal.valueOf(5)).divide(BigDecimal.valueOf(5)).toString());
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("田翔"));
        list.add(new Animal("田翔2"));
         System.out.println(list.stream().map(Animal::getName).collect(Collectors.toList()).toString());
*/

        if(0 == BigDecimal.valueOf(400).compareTo(new BigDecimal("70400").divide(BigDecimal.valueOf(176), 2, BigDecimal.ROUND_HALF_EVEN))) {
             System.out.println("!11");
        }
    }


}