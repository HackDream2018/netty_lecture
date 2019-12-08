package test.designpattern.action.state;

import java.util.Random;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 能抽奖状态对应的行为
 * @date: 2019/12/8
 */
public class CanRaffleState implements State {

    // 每个状态执行后要修改当前对象的状态属性
    private Activity activity;

    public CanRaffleState(Activity activity) {
        this.activity = activity;
    }

    /**
     * 已扣过积分
     */
    @Override
    public void subtractMoney() {
         System.out.println("已经扣过积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖...");
        Random random = new Random();
        int num = random.nextInt(10);//0-9
        if(0 == num) {
            // 中奖
            System.out.println("恭喜, 中奖了");
            return true;
        }else {
            System.out.println("未中奖, 再接再厉");
            activity.setState(activity.getNoRaffleState());
            return false;
        }
    }

    @Override
    public void dispensePrize() {
        int prizeStock = activity.getCount();
        if(prizeStock > 0) {
            System.out.println("开始派奖");
            if(prizeStock >= 1) {
                activity.setState(activity.getCanAgainDispenseState());
            }
        }else {
             System.out.println("很遗憾, 由于奖品不足导致派奖失败, 已退还50积分");
             activity.setState(activity.getNoAgainDispenseState());
        }
    }
}
