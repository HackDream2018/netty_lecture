package test;

import org.junit.Test;

import java.io.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT{


    @Test
    public void tests() throws Exception {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }

    public static void swap(int a) {
        a = 2;
    }

    public static void swap(String s) {
        s = "2";
    }

    public static void swap(String[] a) {
        a[0] = "7";
        a[1] = "3";
    }

    public static void swap2(String[] a) {
        a = new String[]{"7", "3"};
    }


    @Test
    public void 序列化() throws Exception {
        Animal animal = new Animal("a=1");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:\\迅雷下载\\a.txt")));
        oos.writeObject(animal);
        oos.close();
    }

    @Test
    public void 反序列化() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\迅雷下载\\a.txt")));
        Animal animal = (Animal) ois.readObject();
        System.out.println(animal.getName());
    }


}