package test.designpattern.action.state;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 能再次派奖的抽奖状态对应的行为
 * @date: 2019/12/8
 */
public class CanAgainDispenseState implements State {

    // 每个状态执行后要修改当前对象的状态属性
    private Activity activity;

    public CanAgainDispenseState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void subtractMoney() {
        System.out.println("还有奖品, 继续抽奖");
        activity.setState(activity.getNoRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println("还有奖品, 继续抽奖");
        activity.setState(activity.getNoRaffleState());
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("还有奖品, 继续抽奖");
        activity.setState(activity.getNoRaffleState());
    }
}
