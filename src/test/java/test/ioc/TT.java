package test.ioc;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    public static void main(String[] args) throws Exception {
        // 对象的创建交给容器来处理, 顺便赋值
        MySpring spring = new MySpring();
        Animal animal = (Animal) spring.getBean("test.ioc.Animal");
         System.out.println(animal);
        /*Person person = (Person) spring.getBean("test.ioc.Person");
        System.out.println(person);*/

    }

}
