package test.designpattern.action.mediator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 具体同事类
 * @date: 2019/11/24
 */
public class MasterHouse extends Colleague{

    public MasterHouse(Mediator mediator, String colleagueName) {
        super(mediator, colleagueName);
        // 在实例化同事类同时将其聚合到 中介者 的同事对象容器中
        mediator.register(colleagueName, this);
    }

    public void sendMasterHouse(int stateChange) {
        sendMessage(stateChange);
    }

    @Override
    void sendMessage(int stateChange) {
        super.getMediator().getMessage(stateChange, super.colleagueName);
    }

    /**
     * 业务
     */
    protected void state0() {
         System.out.println("由中介者执行房东0状态的任务");
    }
}
