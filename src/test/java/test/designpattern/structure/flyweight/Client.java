package test.designpattern.structure.flyweight;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/21
 */
public class Client {

    public static void main(String[] args) {
        WebSiteFlyWeightFactory webSiteFactory = new WebSiteFlyWeightFactory();

        // 要一份微博形式发布的网站
        webSiteFactory.getWebSite("微博").use(new User("hack"));

        // 要一份新闻形式发布的网站
        webSiteFactory.getWebSite("新闻").use(new User("tom"));
        // 要一份新闻形式发布的网站
        webSiteFactory.getWebSite("新闻").use(new User("jack"));

        /**
         * 网站的发布形式为: 微博, 使用人是: hack
         * 网站的发布形式为: 新闻, 使用人是: tom
         * 网站的发布形式为: 新闻, 使用人是: jack
         * 享元工厂里享元对象数:2
         */
        System.out.println("享元工厂里享元对象数:" + webSiteFactory.getWebSiteCount());
    }

}
