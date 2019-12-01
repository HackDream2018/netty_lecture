package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    @Test
    public void testMethod() {
        List<Integer> values = Arrays.asList(new Integer[]{1, 2, 3});
        values.forEach(item -> {
             System.out.println(item);
        });
    }


}