package test.designpattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/14
 */
public class College extends AbsComponent {

    private List<AbsComponent> componentList = new ArrayList<>();

    public College(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void add(AbsComponent component) {
        componentList.add(component);
    }

    @Override
    protected void print() {
        System.out.println("--------" + super.getName() + "--------");
        for (AbsComponent component : componentList) {
            component.print();
        }
    }
}
