package test.designpattern.structure.proxy.cglib;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/22
 */
public class TeacherTarget {

    public void teach() {
         System.out.println("目标对象");
    }

    public String sayHello(String name) {
        System.out.println(name+" say hello!");
        return name;
    }

}
