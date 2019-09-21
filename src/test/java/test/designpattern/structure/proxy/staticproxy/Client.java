package test.designpattern.structure.proxy.staticproxy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/22
 */
public class Client {
    public static void main(String[] args) {
        new TeacherProxy(new TeacherTarget()).teach();
    }
}
