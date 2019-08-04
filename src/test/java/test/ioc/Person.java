package test.ioc;

import lombok.Data;
import lombok.ToString;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/5
 */

@ToString
@Data
public class Person {

    private String name;

    private Integer age;

    @MyAnotation({"田翔", "24"})
    public Person() {}



}
