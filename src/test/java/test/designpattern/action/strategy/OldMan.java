package test.designpattern.action.strategy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/13
 */
public class OldMan extends Person{

    private String name;

    public OldMan(String name) {
        this.name = name;
    }

    public void callNumber() {
        System.out.println(this.name +"取号排队");
    }

    public void processBusiness() {
        System.out.println("很多问题搞不清楚, 费力的办理业务中");
    }

    public void leave() {
        System.out.println("拄着拐棍慢慢的离开银行大厅");
    }

}
