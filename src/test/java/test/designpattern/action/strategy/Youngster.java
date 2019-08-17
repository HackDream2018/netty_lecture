package test.designpattern.action.strategy;

import lombok.Data;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/13
 */
@Data
public class Youngster extends Person {

    private String name;

    public Youngster(String name) {
        this.name = name;
    }

    public void callNumber() {
         System.out.println(this.name +"取号排队");
    }

    public void processBusiness() {
        System.out.println("毫不费力的办理业务中");
    }

    public void leave() {
        System.out.println("活蹦乱跳的离开银行大厅");
    }

}
