package test;

import java.util.Date;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/4
 */
public class TT {

    public static void main(String[] args) {
         System.out.println(new Date(System.currentTimeMillis()));
       System.out.println(new Date(System.currentTimeMillis() + (60 * 60 * 2 * 1000) + 1));
        System.out.println("100" + 10L);
        System.out.println(100L + "100");
    }
    
}
