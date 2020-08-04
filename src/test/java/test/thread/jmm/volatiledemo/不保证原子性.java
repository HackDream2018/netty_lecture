package test.thread.jmm.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/8/4
 */

class VolatileData4 {
    volatile AtomicInteger num = new AtomicInteger();

    public void addAtomic() {
        this.num.getAndIncrement();
    }
}

class VolatileData3 {
    volatile int num = 0;

    public void add() {
        this.num++;
    }
}

public class 不保证原子性 {

    public static void main(String[] args) {
//        VolatileData3 data = new VolatileData3();
        VolatileData4 data = new VolatileData4();

        // 20条线程, 每条线程对共享数据自增1000次, 最终按理应该结果是 20000, 但由于volatile不保证原子性, 所以可能不等于20000
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
//                    data.add();
                    data.addAtomic();
                }
            }, "Thread Name: " + i).start();
        }

        // 等待上面的子线程全部执行完(查看当前线程组中的活动线程数量; 2 = 主线程 + gc线程)
        while(Thread.activeCount() > 2) {
            Thread.yield();
        }
         System.out.println(Thread.currentThread().getName() + " finally number :" + data.num);

        /*
         * num++ 为啥会出现低于实际的值?
         * JMM中在每个线程的工作内存里将数据写回到主内存的时候由于不保证原子性(没加锁, 发生并发问题), 导致写覆盖的情况, 因此会比实际值小
         */
    }

}
