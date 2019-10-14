package test.designpattern.action.template.hookmethod;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/10/4
 */
public class PureSoyaMilk extends AbsSoyaMilk{
    /**
     * 纯豆浆无需配料, 空实现
     */
    @Override
    void addBurden() {

    }

    @Override
    protected Boolean custWantBurden() {
        return false;
    }
}
