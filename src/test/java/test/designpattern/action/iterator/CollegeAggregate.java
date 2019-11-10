package test.designpattern.action.iterator;

import java.util.Iterator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 学院容器和具体迭代器的映射接口
 * @date: 2019/11/10
 */
public interface CollegeAggregate {

    String getName();

    /**
     * 增加院系
     */
    void addDepartment(String name, String description);

    /**
     * 返回迭代器
     */
    Iterator createIterator();
}
