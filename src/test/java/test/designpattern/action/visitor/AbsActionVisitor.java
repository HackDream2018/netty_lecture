package test.designpattern.action.visitor;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/10/20
 */
public abstract class AbsActionVisitor {

    abstract void getManResult(AbsPersonElement element);

    abstract void getWomanResult(AbsPersonElement element);

}
