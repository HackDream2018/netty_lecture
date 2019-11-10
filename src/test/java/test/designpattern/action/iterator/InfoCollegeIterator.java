package test.designpattern.action.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 信息技术学院具体迭代器
 * @date: 2019/11/10
 */
public class InfoCollegeIterator implements Iterator {

    // 院系容器类型(集合)
    private ArrayList<Department> departments;
    private int index = 0;


    public InfoCollegeIterator(ArrayList<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        return (index >= departments.size() || departments.get(index) == null) ? false : true;
    }

    @Override
    public Object next() {
        Department department = departments.get(index);
        index++;
        return department;
    }
}
