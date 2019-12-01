package test.designpattern.action.memento;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 备忘录对象
 * @date: 2019/12/1
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
