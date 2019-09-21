package test.designpattern.structure.proxy.staticproxy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/22
 */
public class TeacherProxy implements ITeacher{

    // 聚合进来的目标对象
    private ITeacher target;

    public TeacherProxy(ITeacher iTeacher) {
        this.target = iTeacher;
    }

    @Override
    public void teach() {
        System.out.println("使用代理对象进行前置处理...");
        target.teach();
        System.out.println("使用代理对象进行后置处理...");
    }
}
