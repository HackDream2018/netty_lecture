package test.designpattern.action.visitor;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/10/20
 */
public class Fail extends AbsActionVisitor {

    @Override
    void getManResult(AbsPersonElement element) {
        System.out.println("男评委给选手打分: 不够优秀");
    }

    @Override
    void getWomanResult(AbsPersonElement element) {
        System.out.println("女评委给选手打分: 不够优秀");
    }
}
