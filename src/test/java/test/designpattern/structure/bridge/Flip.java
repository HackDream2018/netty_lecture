package test.designpattern.structure.bridge;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/31
 */
public class Flip extends AbsPhone {

    public Flip(IBrand brand) {
        super(brand);
    }

    public void call() {
        System.out.println("翻盖款式手机");
        super.call();
    }

}
