package test.designpattern.action.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 管理备忘录
 * @date: 2019/12/1
 */
public class Caretaker {

    /**
     * 备忘录对象容器
     */
    private List<Memento> mementos = new ArrayList<>();

    public void add(Memento memento) {
        this.mementos.add(memento);
    }

    /**
     * 获取备忘录对象, 用备忘录对象操作原始对象的状态
     */
    public Memento get(int idx) {
        return mementos.get(idx);
    }

}
