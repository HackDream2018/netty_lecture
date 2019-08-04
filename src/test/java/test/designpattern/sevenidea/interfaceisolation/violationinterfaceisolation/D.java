package test.designpattern.sevenidea.interfaceisolation.violationinterfaceisolation;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 通过依赖接口去调用实现类B中的方法
 * @date: 2019/7/20
 */
public class D {

    public void depend1(Interface1 interface1) {
        interface1.option1();
        interface1.option2();
        interface1.option3();
        interface1.option4();
        interface1.option5();
    }

}
