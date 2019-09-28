package test.designpattern.action.strategy.notuse;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/13
 */
public class TT {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.handleTheBusiness(new Youngster("年轻人"));
        bank.handleTheBusiness(new OldMan("老人家"));
    }

}
