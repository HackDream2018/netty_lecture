package test.designpattern.create.prototype;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/18
 */
public class TestMethod {
    
    public static void main(String[] args) {
        Sheep src = new Sheep("多莉", 6);
        src.friend = new FriendSheep("罗山炮");
        //1. clone()实现深拷贝
        /*Sheep copy1 = (Sheep)src.clone();
        Sheep copy2 = (Sheep)src.clone();*/
        
        //2. 序列化和反序列化实现深拷贝
        Sheep copy1 = (Sheep)src.deepClone();
        Sheep copy2 = (Sheep)src.deepClone();
        System.out.println(src + "原型羊的朋友哈希值为: " + src.friend.hashCode()); // Sheep{name='多莉', age=6}原型羊的朋友哈希值为: 366712642

        System.out.println(copy1 + "复制羊的朋友哈希值为: " + copy1.friend.hashCode());// Sheep{name='多莉', age=6}复制羊的朋友哈希值为: 1829164700
        System.out.println(copy2 + "复制羊的朋友哈希值为: " + copy2.friend.hashCode());// Sheep{name='多莉', age=6}复制羊的朋友哈希值为: 2018699554
    }
    
}
