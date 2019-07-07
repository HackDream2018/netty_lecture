package test.polymorphic;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    public static void main(String[] args) {
        Person person = new Man();
        System.out.println(person.name);
        person.eat();

    }

}
