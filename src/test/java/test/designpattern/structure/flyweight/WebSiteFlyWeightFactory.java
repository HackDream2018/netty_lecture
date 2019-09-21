package test.designpattern.structure.flyweight;

import java.util.HashMap;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/21
 */
public class WebSiteFlyWeightFactory {

    // 集合充当缓存容器
    private HashMap<String, WebSiteFlyWeight> pool = new HashMap<>();

    /**
     * 根据网站类型从缓存容器中返回享元网站对象, 没有则新建后放入容器
     */
    public IWebSiteFlyWeight getWebSite(String siteType) {
        if(!pool.containsKey(siteType)) {
            pool.put(siteType, new WebSiteFlyWeight(siteType));
        }
        return pool.get(siteType);
    }

    public int getWebSiteCount() {
        return pool.size();
    }

}
