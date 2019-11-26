package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    @Test
    public void testMethod() {
        Map<String, Boolean> map = new HashMap<>();
        map.put("1", true);
         System.out.println(map.containsKey("1"));
    }


}