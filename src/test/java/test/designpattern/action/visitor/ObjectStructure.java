package test.designpattern.action.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 数据结构管理枚举类
 * @date: 2019/10/20
 */
public class ObjectStructure {

    // 维护数据结构容器
    private List<AbsPersonElement> persons = new LinkedList<>();

    /**
     * 添加数据结构元素
     */
    public void attach(AbsPersonElement person) {
        persons.add(person);
    }

    /**
     * 删除数据结构元素
     */
    public void detach(AbsPersonElement person) {
        persons.remove(person);
    }

    /**
     * 遍历数据结构容器
     */
    public void display(AbsActionVisitor visitor) {
        persons.forEach(item -> item.accept(visitor));
    }

}
