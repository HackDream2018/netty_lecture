package test.designpattern.action.mediator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/11/24
 */
public class Client {
    public static void main(String[] args) {
        // 创建中介者对象
        Mediator mediator = new MediatorImpl();

        // 创建同事对象, 且加入到中介者容器内
        MasterHouse masterHouse = new MasterHouse(mediator, "masterHouse");
        Wife wife = new Wife(mediator, "wife");
        masterHouse.sendMasterHouse(0);
        wife.sendMasterHouse(0);
        wife.sendMasterHouse(1);

        /*由中介者执行房东0状态的任务
        由中介者执行房东妻子0状态的任务
        由中介者执行房东妻子1状态的任务*/
    }
    
}
