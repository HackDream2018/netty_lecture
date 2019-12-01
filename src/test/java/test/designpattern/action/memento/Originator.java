package test.designpattern.action.memento;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 源数据对象
 * @date: 2019/12/1
 */
public class Originator {

    /**
     * 对象状态
     */
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * 备忘对象录入到备忘录
     */
    public Memento saveStateMemento() {
        return new Memento(this.state);
    }

    /**
     * 从备忘录里取状态回退
     */
    public void getStateFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}
