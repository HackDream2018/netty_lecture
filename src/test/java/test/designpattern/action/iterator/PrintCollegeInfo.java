package test.designpattern.action.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/11/10
 */
public class PrintCollegeInfo {

    private ArrayList<CollegeAggregate> collegeAggregates;

    public PrintCollegeInfo(ArrayList<CollegeAggregate> collegeAggregates) {
        this.collegeAggregates = collegeAggregates;
    }

    /**
     * 遍历所有学院
     */
    public void printCollege() {
        Iterator<CollegeAggregate> iterator = collegeAggregates.iterator();
        while (iterator.hasNext()) {
            CollegeAggregate collegeAggregate = iterator.next();
            System.out.println(String.format("======%s======", collegeAggregate.getName()));
            printDepartment(collegeAggregate.createIterator());
        }
    }

    /**
     * 遍历所有的院系
     */
    public void printDepartment(Iterator iterator) {
        while (iterator.hasNext()) {
            Department department = (Department)iterator.next();
            System.out.println(String.format("院系:%s ----- 描述:%s", department.getName(), department.getDescription()));
        }
    }
}
