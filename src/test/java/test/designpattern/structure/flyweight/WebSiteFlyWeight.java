package test.designpattern.structure.flyweight;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/21
 */
public class WebSiteFlyWeight implements IWebSiteFlyWeight {
    /**
     * 内部状态
     */
    private String type;

    public WebSiteFlyWeight(String type) {
        this.type = type;
    }

    /**
     * User外部对象
     */
    @Override
    public void use(User user) {
        System.out.println(String.format("网站的发布形式为: %s, 使用人是: %s", type, user.getUserName()));
    }
}
