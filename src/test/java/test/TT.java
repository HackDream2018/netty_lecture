package test;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/4
 */
public class TT {

    public static void main(String[] args) throws Exception {
       /* Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getConstructor(String[].class);
        String[] strArray = new String[]{"速度", "激情"};
        constructor.newInstance(new Object[]{strArray});
        */
        String[] str = {"1", "2", "3"};
        Object[] str2 = new Object[]{str};
        System.out.println(str2.length); //1


    }

}
