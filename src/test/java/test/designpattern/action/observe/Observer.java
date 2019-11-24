package test.designpattern.action.observe;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 被观察者
 * @date: 2019/11/24
 */
public interface Observer {

    /**
     * 提供给观察者更新的方法
     */
    void update(Float temperature, Float pressure, Float humidity);

}
