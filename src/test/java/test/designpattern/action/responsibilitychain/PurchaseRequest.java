package test.designpattern.action.responsibilitychain;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 采购请求
 * @date: 2019/12/14
 */
public class PurchaseRequest {

    /**
     * 请求类型
     */
    private int type;

    /**
     * 采购价格
     */
    private float pirce;

    public PurchaseRequest(int type, float pirce) {
        this.type = type;
        this.pirce = pirce;
    }

    public int getType() {
        return type;
    }

    public float getPirce() {
        return pirce;
    }

}
