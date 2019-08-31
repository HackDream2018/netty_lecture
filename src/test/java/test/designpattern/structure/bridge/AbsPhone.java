package test.designpattern.structure.bridge;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/31
 */
public abstract class AbsPhone {

    // 聚合品牌
    private IBrand brand;

    public AbsPhone(IBrand brand) {
        this.brand = brand;
    }

    protected void call() {
        brand.call();
    }

}
