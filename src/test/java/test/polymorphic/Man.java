package test.polymorphic;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/7
 */
public class Man extends Person{

    public String age = "子类的age属性";

    protected void eat() {
        System.out.println("子类的eat()");
    }

}
