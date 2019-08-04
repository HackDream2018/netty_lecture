package test.designpattern.sevenidea.interfaceisolation;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 通过依赖接口去调用实现类A中的方法
 * @date: 2019/7/20
 */
public class C {

    public void depend1(Interface1 interface1) {
        interface1.option1();
    }

    public void depend2(Interface2 interface2) {
        interface2.option2();
        interface2.option3();
    }
}
