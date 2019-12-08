package test.designpattern.action.state;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 抽奖活动对象
 * @date: 2019/12/8
 */
public class Activity {

    private State state;

    private int count;

    public Activity(int count) {
        this.state = getNoRaffleState();
        this.count = count;
    }

    // 4个状态
    State noRaffleState = new NoRaffleState(this);
    State canRaffleState = new CanRaffleState(this);
    State canAgainDispenseState = new CanAgainDispenseState(this);
    State noAgainDispenseState = new NoAgainDispenseState(this);

    /**
     * 调用当前对象的扣钱方法
     */
    public void subtractMoney() {
        this.state.subtractMoney();
    }

    /**
     * 调用当前对象的抽奖方法
     */
    public void raffle() {
        if(this.state.raffle()) {
            // 领取奖品
            this.state.dispensePrize();
        }
    }

    /**
     * 每次派奖,奖品数--
     */
    public int getCount() {
        int curCount = count;
        count--;
        return curCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getNoRaffleState() {
        return noRaffleState;
    }

    public void setNoRaffleState(State noRaffleState) {
        this.noRaffleState = noRaffleState;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }

    public void setCanRaffleState(State canRaffleState) {
        this.canRaffleState = canRaffleState;
    }

    public State getCanAgainDispenseState() {
        return canAgainDispenseState;
    }

    public void setCanAgainDispenseState(State canAgainDispenseState) {
        this.canAgainDispenseState = canAgainDispenseState;
    }

    public State getNoAgainDispenseState() {
        return noAgainDispenseState;
    }

    public void setNoAgainDispenseState(State noAgainDispenseState) {
        this.noAgainDispenseState = noAgainDispenseState;
    }
}
