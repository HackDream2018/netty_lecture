package test.designpattern.action.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/11/24
 */
public class MediatorImpl implements Mediator{

    private Map<String, Colleague> colleagues = new HashMap();

    @Override
    public void register(String colleagueName, Colleague colleague) {
        colleagues.put(colleagueName, colleague);
    }

    @Override
    public void getMessage(int stateChange, String colleagueName) {
        // 接收房东同事对象发送的消息
        if(colleagues.get(colleagueName) instanceof MasterHouse) {
            MasterHouse masterHouse = (MasterHouse)colleagues.get(colleagueName);
            if(0 == stateChange) {
                masterHouse.state0();
            }
        }else if(colleagues.get(colleagueName) instanceof Wife) { // 接收房东妻子同事对象发送的消息
            Wife wife = (Wife)colleagues.get(colleagueName);
            if(0 == stateChange) {
                wife.state0();
            }else if(1 == stateChange) {
                wife.state1();
            }
        }
    }

    @Override
    public void sendMessage() {
        // TODO 操作其他同事类
    }
}
