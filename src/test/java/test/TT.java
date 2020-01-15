package test;

import org.junit.Test;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    @Test
    public void testMethod() {
        
        String str = "1|3.2.txt";
        System.out.println(str.substring(str.lastIndexOf(".")));
    }


}