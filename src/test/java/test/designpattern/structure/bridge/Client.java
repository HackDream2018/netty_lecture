package test.designpattern.structure.bridge;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/31
 */
public class Client {
    
    public static void main(String[] args) {
        // 触摸屏款式(款式 + 品牌)
        AbsPhone huaWeiTouchScreenPhone = new TouchScreen(new HuaWei());
        AbsPhone xiaoMiTouchScreenPhone = new TouchScreen(new XiaoMi());
        AbsPhone vivoTouchScreenPhone = new TouchScreen(new Vivo());
        huaWeiTouchScreenPhone.call();
        xiaoMiTouchScreenPhone.call();
        vivoTouchScreenPhone.call();
        System.out.println("--------------------------------------------------");
        // 翻盖款式(款式 + 品牌)
        AbsPhone huaWeiFlipPhone = new Flip(new HuaWei());
        AbsPhone xiaoMiFlipPhone = new Flip(new XiaoMi());
        AbsPhone vivoFlipPhone = new Flip(new Vivo());
        huaWeiFlipPhone.call();
        xiaoMiFlipPhone.call();
        vivoFlipPhone.call();
        System.out.println("--------------------------------------------------");
        // 5G(款式 + 品牌)
        AbsPhone huaWeiFiveGPhone = new FiveG(new HuaWei());
        AbsPhone xiaoMiFiveGPhone = new FiveG(new XiaoMi());
        huaWeiFiveGPhone.call();
        xiaoMiFiveGPhone.call();
    }
    
}
