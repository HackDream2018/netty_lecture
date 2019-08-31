package test.designpattern.structure.bridge;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/31
 */
public class FiveG extends AbsPhone{

    public FiveG(IBrand brand) {
        super(brand);
    }

    public void call() {
        System.out.println("5G手机");
        super.call();
    }
}
