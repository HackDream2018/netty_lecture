package test.designpattern.action.strategy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/12/8
 */
public class Java {
    
    public static void main(String[] args) {

        Integer[] data = {9, 1, 3,4};
        // 升序策略
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2) return 1;
                else return -1;
            }
        };

        // 降序策略
        Comparator<Integer> comparator2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2) return 1;
                else return -1;
            }
        };
        // 传不同的排序策略执行排序功能
        Arrays.sort(data,comparator);
        System.out.println(Arrays.toString(data));
        Arrays.sort(data,comparator2);
        System.out.println(Arrays.toString(data));
    }
    
}
