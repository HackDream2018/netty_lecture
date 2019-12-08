package test.designpattern.action.state;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 状态接口, 内涵抽象行为
 * @date: 2019/12/8
 */
public interface State {

    // 扣除50积分
    void subtractMoney();

    // 抽奖后是否中奖
    boolean raffle();

    // 派奖
    void dispensePrize();
}
