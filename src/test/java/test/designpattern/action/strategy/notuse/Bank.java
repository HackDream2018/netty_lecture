package test.designpattern.action.strategy.notuse;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 银行只处理业务, 制定流程
 * @date: 2019/7/13
 */
public class Bank {

    public void handleTheBusiness(Youngster y) {
        System.out.println("欢迎您到本行办理业务~");
        y.callNumber();
        y.processBusiness();
        y.leave();
        System.out.println("欢迎下次光临!");
    }

    public void handleTheBusiness(OldMan o) {
        System.out.println("欢迎您到本行办理业务~");
        o.callNumber();
        o.processBusiness();
        o.leave();
        System.out.println("欢迎下次光临!");
    }

}
