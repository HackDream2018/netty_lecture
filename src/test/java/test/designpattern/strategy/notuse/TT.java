package test.designpattern.strategy.notuse;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/13
 */
public class TT {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Youngster youngster = new Youngster("年轻人");
        bank.handleTheBusiness(youngster);

        OldMan oldMan = new OldMan("老人家");
        bank.handleTheBusiness(oldMan);
    }

}
