package test.designpattern.structure.proxy.dynamic;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/22
 */
public class Client {
    public static void main(String[] args) {
        // 给目标对象创建代理对象
        ITeacher proxyObj = (ITeacher)new TeacherProxyFactory(new TeacherTarget()).getProxyInstance();
        proxyObj.teach();
    }
}
