package test.designpattern.action.state;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/12/8
 */
public class Client {

    public static void main(String[] args) {
        // 创建活动, 初始化一个奖品
        Activity activity = new Activity(2);

        // 连续抽10次
        for(int i = 0;i < 100; i++) {
            System.out.println(String.format("第%s次抽奖", i+1));
             // 第一步: 扣钱
            activity.subtractMoney();
            // 第二步: 抽奖
            activity.raffle();
        }
    }

}
