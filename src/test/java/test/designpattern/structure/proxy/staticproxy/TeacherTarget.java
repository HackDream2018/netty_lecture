package test.designpattern.structure.proxy.staticproxy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/22
 */
public class TeacherTarget implements ITeacher {
    @Override
    public void teach() {
         System.out.println("目标对象");
    }
}
