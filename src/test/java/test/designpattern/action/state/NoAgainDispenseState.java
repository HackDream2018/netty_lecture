package test.designpattern.action.state;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 不能再次派奖的抽奖状态对应的行为
 * @date: 2019/12/8
 */
public class NoAgainDispenseState implements State {

    // 每个状态执行后要修改当前对象的状态属性
    private Activity activity;

    public NoAgainDispenseState(Activity activity) {
        this.activity = activity;
    }

    /**
     * 默认不能抽奖, 当扣除积分后可以抽奖
     */
    @Override
    public void subtractMoney() {
         System.out.println("奖品发完了, 请下次参加");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发完了, 请下次参加");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发完了, 请下次参加");
    }
}
