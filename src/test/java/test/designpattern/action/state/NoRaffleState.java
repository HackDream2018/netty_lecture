package test.designpattern.action.state;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 不能抽奖状态对应的行为
 * @date: 2019/12/8
 */
public class NoRaffleState implements State {

    // 每个状态执行后要修改当前对象的状态属性
    private Activity activity;

    public NoRaffleState(Activity activity) {
        this.activity = activity;
    }

    /**
     * 默认不能抽奖, 当扣除积分后可以抽奖
     */
    @Override
    public void subtractMoney() {
        System.out.println("扣除50积分成果, 您现在可以进行抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    /**
     * 当前状态对应的行为不能抽奖
     */
    @Override
    public boolean raffle() {
        System.out.println("还没扣款, 暂时不能抽奖");
        activity.setState(activity.getNoRaffleState());
        return false;
    }

    /**
     * 当前状态对应的行为不能派奖
     */
    @Override
    public void dispensePrize() {
        System.out.println("还没抽奖, 不能派奖");
        activity.setState(activity.getNoRaffleState());
    }
}
