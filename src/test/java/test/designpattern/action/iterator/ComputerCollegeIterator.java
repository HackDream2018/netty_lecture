package test.designpattern.action.iterator;

import java.util.Iterator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 计算机学院具体迭代器
 * @date: 2019/11/10
 */
public class ComputerCollegeIterator implements Iterator {

    // 院系容器类型(数组)
    private Department[] departments;

    // 遍历位置
    int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        return (position >= departments.length || departments[position] == null) ? false : true;
    }

    @Override
    public Object next() {
        Department department = departments[position];
        position++;
        return department;
    }
}
