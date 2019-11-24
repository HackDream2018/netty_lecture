package test.designpattern.action.mediator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 中介者
 * @date: 2019/11/24
 */
public interface Mediator {
    /**
     * 将同事类注册到中介者容器
     */
    void register(String colleagueName, Colleague colleague);

    /**
     * 接收具体同事类发出的消息, 协调同事对象
     */
    void getMessage(int stateChange, String colleagueName);

    /**
     * 发送消息给其他同事类
     */
    void sendMessage();

}
