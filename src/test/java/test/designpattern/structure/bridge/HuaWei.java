package test.designpattern.structure.bridge;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/31
 */
public class HuaWei implements IBrand {

    @Override
    public void call() {
         System.out.println("华为手机打电话");
    }

}