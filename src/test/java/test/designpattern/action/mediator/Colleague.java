package test.designpattern.action.mediator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 抽象同事类
 * @date: 2019/11/24
 */
public abstract class Colleague {

    private Mediator mediator;

    public String colleagueName;

    public Colleague(Mediator mediator, String colleagueName) {
        this.mediator = mediator;
        this.colleagueName = colleagueName;
    }

    public Mediator getMediator() {
        return this.mediator;
    }

    /**
     * 发送消息给中介者
     */
    abstract void sendMessage(int stateChange);
}
