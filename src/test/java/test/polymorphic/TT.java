package test.polymorphic;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.name);
        WoMan woMan = (WoMan)person;
        person.eat();

    }

}
