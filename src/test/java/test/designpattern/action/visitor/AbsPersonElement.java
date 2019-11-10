package test.designpattern.action.visitor;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 数据结构
 * @date: 2019/10/20
 */
public abstract class AbsPersonElement {
    /**
     * 提供接收访问对象的方法
     */
    abstract void accept(AbsActionVisitor visitor);

}
