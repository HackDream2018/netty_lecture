package test.designpattern.strategy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 制定业务流程
 * @date: 2019/7/13
 */
public class Bank {

    public void handleTheBusiness(Person p) {
        System.out.println("欢迎您到本行办理业务~");
        p.callNumber();
        p.processBusiness();
        p.leave();
        System.out.println("欢迎下次光临!");
    }

}
