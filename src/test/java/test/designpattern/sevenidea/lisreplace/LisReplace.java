package test.designpattern.sevenidea.lisreplace;

import org.junit.Test;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/28
 */
public class LisReplace {

    @Test
    public void testMethod() {
        A a = new A();
        System.out.println("2-1=" + a.function(2, 1));
        System.out.println("---------------------");
        B b = new B();
        // B类的父类没有相减的操作, 编者不会有写错
        System.out.println("2+1=" + b.function(2, 1));// 输出: 3
        System.out.println("2-1=" + b.a.function(2, 1));
    }

    /**
     * 存通用的属性和行为
     */
    class Base {}

    class A extends Base{
        // 求差
        public int function(int num1, int num2) {
            return num1 - num2;
        }
    }

    class B extends Base{
        // B类想使用A类的function()使用组合方式
        A a = new A();

        // 求和
        public int function(int num1, int num2) {
            return num1 + num2;
        }
    }

}

