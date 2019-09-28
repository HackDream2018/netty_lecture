package test.designpattern.structure.composite;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/14
 */

public abstract class AbsComponent {

    private String name;
    private String desc;

    public AbsComponent(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    /**
     * 叶子节点无需重写
     */
    protected void add(AbsComponent component) {
        // 由子类重写, 不得直接调用父类方法
        throw new UnsupportedOperationException();
    }

    protected abstract void print();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
