package test.hashmap;


import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/3/31
 */
public class LRUCache extends LinkedHashMap {
    // 最大容量
    private final int MAX_SIZE = 3;

    /**
     * @param cacheSize: 缓存容量
     */
    public LRUCache(int cacheSize) {
        // accessOrder: true 按访问顺序进行排序, 最新访问的放在头结点
        super((int)Math.ceil(cacheSize/0.75)+1, 0.75F, true);
    }

    /**
     * 容器的容量大于最大容量, 返回true, 新加入对象的同时删除尾节点的数据
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size() > MAX_SIZE;
    }

    @Test
    public void tests() throws Exception {
        Map<String, Integer> lruCache = new LRUCache(3);
        lruCache.put("a", 1);
        lruCache.put("b", 2);
        for (Map.Entry<String, Integer> entry: lruCache.entrySet()) {
            System.out.println(String.format("key: %s, value: %s", entry.getKey(), entry.getValue()) );
        }
        lruCache.get("a");
        lruCache.put("c", 3);
        System.out.println("--------------------------------------------------");
        for (Map.Entry<String, Integer> entry: lruCache.entrySet()) {
            System.out.println(String.format("key: %s, value: %s", entry.getKey(), entry.getValue()) );
        }
        lruCache.put("d", 4);
        System.out.println("--------------------------------------------------");
        for (Map.Entry<String, Integer> entry: lruCache.entrySet()) {
            System.out.println(String.format("key: %s, value: %s", entry.getKey(), entry.getValue()) );
        }
    }
}
