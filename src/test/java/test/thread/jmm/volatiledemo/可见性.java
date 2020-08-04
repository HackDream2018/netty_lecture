package test.thread.jmm.volatiledemo;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/7/26
 */

/**
 * 没加volatile展示不可见效果
 */
class VolatileData {
    int num = 0;

    public void updateNum() {
        this.num = 60;
    }
}

/**
 * 展示可见效果
 */
class VolatileData2 {
    volatile int num = 0;

    public void updateNum() {
        this.num = 60;
    }
}

public class 可见性 {


   public static void main(String[] args){
       //VolatileData data = new VolatileData();
       VolatileData2 data = new VolatileData2();

       new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 准备将自己工作内存中的num变量由0 改为 60");
           try {
               Thread.sleep(3 * 1000);
           } catch (InterruptedException e) {}
           data.updateNum();
           System.out.println(Thread.currentThread().getName() + "改好了且写回到了主内存");
       }, "线程1").start();

       // 其他线程在等待感应
       while (0 == data.num) {}

        System.out.println(Thread.currentThread().getName() + "感应到了值的变化, num为: " + data.num);
   }

}
