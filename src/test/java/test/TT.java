package test;

import org.junit.Test;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT{

public static void main(String[] args)throws Exception {
    
}


    public static void swap(int a) {
        a = 2;
    }

    public static void swap(String s) {
        s = "2";
    }

    public static void swap(String[] a) {
        a[0] = "7";
        a[1] = "3";
    }

    public static void swap2(String[] a) {
        a = new String[]{"7", "3"};
    }


    @Test
    public void 序列化() throws Exception {
        int[][] arr = {{2,5},{1},{3,2,4},{1,7,5,9}};
         System.out.println(arr[0][1]);

    }

    @Test
    public void 反序列化() throws Exception {
      Long l = 123456L;
      Integer i = 123456;
      Integer i2 = 123456;
       System.out.println(i.equals(i2));
    }


}