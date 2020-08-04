package test.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put(new MapKey("1"), "VA");
        map.put(new MapKey("2"), "VA");
        map.put(new MapKey("3"), "VA");
        map.put(new MapKey("4"), "VA");
        map.put(new MapKey("5"), "VA");
        map.put(new MapKey("6"), "VA");
        map.put(new MapKey("7"), "VA");
        map.put(new MapKey("8"), "VA");
        map.put(new MapKey("9"), "VA");
        map.put(new MapKey("10"), "VA");
        map.put(new MapKey("11"), "VA");
        map.put(new MapKey("12"), "VA");
        map.put(new MapKey("13"), "VA");

        for(int i = 1; i <= 9; i++) {
            map.put(new MapKey("A"), "VA");
        }

    }
}