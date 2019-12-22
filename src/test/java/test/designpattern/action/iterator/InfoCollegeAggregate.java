package test.designpattern.action.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 容器与具体迭代器关联
 * @date: 2019/11/10
 */
public class InfoCollegeAggregate implements CollegeAggregate {

    // 院系容器类型(数组)
    private ArrayList<Department> departments;

    public InfoCollegeAggregate() {
        this.departments = new ArrayList<>();
        this.addDepartment("通信技术专业", "通信技术描述");
    }

    @Override
    public String getName() {
        return "信息技术学院";
    }

    @Override
    public void addDepartment(String name, String description) {
        Department department = new Department(name, description);
        departments.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departments);
    }
}
