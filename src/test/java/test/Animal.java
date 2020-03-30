package test;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/19
 */

public class Animal   {


    private static final long serialVersionUID = 4256093278952817278L;
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
         System.out.println("Animal eat()");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
