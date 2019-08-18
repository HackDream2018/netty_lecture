package test.designpattern.create.prototype;


import java.io.*;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/18
 */

public class Sheep implements Cloneable, Serializable {
    private String name;
    private Integer age;
    public FriendSheep friend;

    public Sheep(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // clone()深拷贝
    @Override
    protected Object clone() {
        try {
            // 1.先对本类的基本数据类型的属性进行克隆
            Object obj = super.clone();
            Sheep sheep = (Sheep)obj;
            // 2. 引用数据类型单独克隆
            sheep.friend = (FriendSheep)friend.clone();
            return obj;
        }catch (Exception e) {}
        return null;
    }

    // 序列化深拷贝
    public Object deepClone() {
        // 创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //1. 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // 将当前对象转换为对象流输出 -> 字节数组输出流
            oos.writeObject(this);

            //2. 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return ois.readObject();
        }catch (Exception e) {

        }finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            }catch (Exception e) {}
        }
        return null;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
