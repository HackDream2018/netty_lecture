package test.designpattern.sevenidea.interfaceisolation.violationinterfaceisolation;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: A类只想有option1, 2, 3方法
 * @date: 2019/7/20
 */
public class A implements Interface1 {
    @Override
    public void option1() {
         System.out.println("A实现类的option1()");
    }

    @Override
    public void option2() {
        System.out.println("A实现类的option2()");
    }

    @Override
    public void option3() {
        System.out.println("A实现类的option3()");
    }

    @Override
    public void option4() {
        System.out.println("A实现类的option4()");
    }

    @Override
    public void option5() {
        System.out.println("A实现类的option5()");
    }
}
