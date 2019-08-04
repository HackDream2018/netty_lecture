package test.designpattern.sevenidea.interfaceisolation;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/20
 */
public class InterfaceIsolation {

    public static void main(String[] args) {
        C c = new C();
        // C类通过依赖接口去调用A类的实现方法
        c.depend1(new A());
        c.depend2(new A());
        D d = new D();
        // D类通过依赖接口去调用B类的实现方法
        d.depend1(new B());
        d.depend2(new B());
    }

}
