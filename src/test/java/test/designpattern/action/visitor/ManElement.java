package test.designpattern.action.visitor;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/10/20
 */
public class ManElement extends AbsPersonElement{

    /**
     * 双分派
     * 1. 将具体Man访问对象传入ManElement数据结构元素;
     * 2. 将ManElement数据结构元素对象再通过参数传出去;
     */
    @Override
    void accept(AbsActionVisitor visitor) {
        visitor.getManResult(this);
    }
}
