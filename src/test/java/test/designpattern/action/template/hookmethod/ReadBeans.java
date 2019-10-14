package test.designpattern.action.template.hookmethod;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/28
 */
public class ReadBeans extends AbsSoyaMilk {
    @Override
    void addBurden() {
         System.out.println("第二步: 加入上好的红豆");
    }
}
