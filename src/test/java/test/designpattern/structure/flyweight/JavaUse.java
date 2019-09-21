package test.designpattern.structure.flyweight;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/21
 */
public class JavaUse {
    
    public static void main(String[] args) {
        Integer x = Integer.valueOf(127);
        Integer y = new Integer(127);
        Integer z = Integer.valueOf(127);
        Integer m = 127;
        System.out.println(x.equals(y));// true
        System.out.println(x == y);// false
        System.out.println(x == z);// true
        System.out.println(x == m);// true

        System.out.println("--------------------");

        Integer x2 = Integer.valueOf(128);
        Integer y2 = new Integer(128);
        Integer z2 = Integer.valueOf(128);
        Integer m2 = 128;
        Integer m22 = 128;
        Integer t2 = 127;
        Integer t22 = 127;
        System.out.println(x2.equals(y2));// true
        System.out.println(x2 == y2);// false
        System.out.println(x2 == z2);// false
        System.out.println(x2 == m2);// false
        System.out.println(m2 == m22);// false
        System.out.println(t2 == t22);// tue
    }
}
