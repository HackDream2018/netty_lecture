package test.designpattern.action.template.hookmethod;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/28
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("-----制作红豆豆浆----");
        AbsSoyaMilk redBeans = new ReadBeans();
        redBeans.make();
        System.out.println("-----制作黑豆豆浆----");
        AbsSoyaMilk blackBeans = new BlackBeans();
        blackBeans.make();
        System.out.println("-----制作纯豆浆----");
        PureSoyaMilk soyaMilk = new PureSoyaMilk();
        soyaMilk.make();
    }

}
