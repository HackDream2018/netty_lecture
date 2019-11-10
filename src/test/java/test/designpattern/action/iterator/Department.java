package test.designpattern.action.iterator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 院系
 * @date: 2019/11/10
 */
public class Department {

    private String name;
    private String description;

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
