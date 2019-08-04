package test.designpattern.strategy;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/13
 */
public class TT {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Person youngster = new Youngster("年轻人");
        bank.handleTheBusiness(youngster);

        Person oldMan = new OldMan("老人家");
        bank.handleTheBusiness(oldMan);
    }

}
