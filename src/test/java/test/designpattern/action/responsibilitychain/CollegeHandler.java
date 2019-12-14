package test.designpattern.action.responsibilitychain;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 院长审批采购金额
 * @date: 2019/12/14
 */
public class CollegeHandler extends Handler{

    public CollegeHandler(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getPirce() <= 10000 && request.getPirce() > 5000)
             System.out.println(String.format("请求类型: %s 被 '%s' 处理器处理", request.getType(), super.name));
        else super.handler.processRequest(request);// 将请求传递给下个处理器
    }
}
