package test.polymorphic;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    public static void main(String[] args) {
        Man man = new Man();
        Person person = (Person)man;
        Animal animal = (Animal)man;
    }

}
