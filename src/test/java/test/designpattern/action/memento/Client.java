package test.designpattern.action.memento;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/12/1
 */
public class Client {

    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("生命值: 100");
        caretaker.add(originator.saveStateMemento());

        originator.setState("生命值: 90");
        caretaker.add(originator.saveStateMemento());

        originator.setState("生命值: 80");
        caretaker.add(originator.saveStateMemento());
        System.out.println("回退前源数据对象的生命值: " + originator.getState());

        // 从备忘录容器中取出某个备忘录对象后进行回退源数据对象操作
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("回退后源数据对象的生命值: " + originator.getState());
    }

}
