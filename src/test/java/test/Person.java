package test;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/11
 */
public class Person {

    public Person(String ... strs) {
        String newStr = "";
         for(String str :  strs) {
             newStr += str;
         }
          System.out.println(newStr);
    }

    private String eat(String str, Long l) {
         System.out.println("吃饭" + str);
         return str;
    }

    public void sleep() {
        System.out.println("睡觉");
    }

}
