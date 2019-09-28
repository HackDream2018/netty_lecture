package test.designpattern.structure.proxy.cglib;

/**
 * @version v1.0
 * @author: TianXiang * @description:
 * @date: 2019/9/22
 */
public class Client {
    public static void main(String[] args) {
        // 给目标对象创建代理对象
        TeacherTarget proxyObj = (TeacherTarget)new TeacherProxyFactory(new TeacherTarget()).getProxyInstance();
        // 执行代理对象时触发intecept方法, 实现对目标对象的调用
        proxyObj.teach();
        proxyObj.sayHello("小田");
    }
}
