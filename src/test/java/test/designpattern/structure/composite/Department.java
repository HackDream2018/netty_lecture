package test.designpattern.structure.composite;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/14
 */
public class Department extends AbsComponent {

    public Department(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void print() {
        System.out.println("--------" + super.getName() + "--------");
    }
}
