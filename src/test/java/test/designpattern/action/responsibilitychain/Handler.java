package test.designpattern.action.responsibilitychain;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 抽象处理器/接收者
 * @date: 2019/12/14
 */
public abstract class Handler {

    /**
     * 用于子类调用下个处理器对象
     */
    protected Handler handler;

    /**
     * 处理器名字
     */
    protected String name;

    public Handler(String name) {
        this.name = name;
    }

    /**
     * 设置下个处理器
     */
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    /**
     * 由具体处理器处理请求
     */
    public abstract void processRequest(PurchaseRequest request);
}
