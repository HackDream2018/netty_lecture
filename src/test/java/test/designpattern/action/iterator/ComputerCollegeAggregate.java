package test.designpattern.action.iterator;

import java.util.Iterator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/11/10
 */
public class ComputerCollegeAggregate implements CollegeAggregate {

    // 院系容器类型(数组)
    private Department[] departments;

    // 容器中院系个数
    private int numOfDepartment = 0;

    public ComputerCollegeAggregate() {
        this.departments = new Department[2];
        this.addDepartment("Java专业", "Java描述");
        this.addDepartment("C#专业", "C#描述");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String description) {
        Department department = new Department(name, description);
        departments[numOfDepartment] = department;
        numOfDepartment++;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
