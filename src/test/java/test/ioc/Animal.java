package test.ioc;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/5
 */

public class Animal {

    private String name;

    private Integer age;

    private String gender;

    @MyAnotation({"狗狗", "1", "女"})
    public Animal() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
