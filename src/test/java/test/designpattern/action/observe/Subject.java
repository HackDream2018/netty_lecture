package test.designpattern.action.observe;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 观察者
 * @date: 2019/11/24
 */
public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
