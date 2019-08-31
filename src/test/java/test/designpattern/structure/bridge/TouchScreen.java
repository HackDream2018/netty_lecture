package test.designpattern.structure.bridge;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/31
 */
public class TouchScreen extends AbsPhone {

    public TouchScreen(IBrand brand) {
        super(brand);
    }

    public void call() {
        System.out.println("触摸屏款式手机");
        super.call();
    }

}
