package test.designpattern.sevenidea.lisreplace.violationlisreplace;

import org.junit.Test;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 没用到李氏替换
 * @date: 2019/7/28
 */
public class LisReplace {

    @Test
    public void testMethod() {
        A a = new A();
        System.out.println("2-1=" + a.subtract(2, 1));
        System.out.println("---------------------");
        B b = new B();
        // B在调用时由于是继承关系所以以为调用的是A类的相减操作方法
        System.out.println("2-1=" + b.subtract(2, 1));// 输出: 3
    }

    class A {
        // 返回差值
        public int subtract(int num1, int num2) {
            return num1 - num2;
        }
    }

    class B extends A{
        // 无意识重写了父类方法
        public int subtract(int num1, int num2) {
            return num1 + num2;
        }
    }

}
