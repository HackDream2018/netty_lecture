package test.thread;

import org.junit.Test;

import java.util.concurrent.Callable;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/3/18
 */
public class ThreadTest {

    @Test
    public void run() {
        // run不会创建新的线程, 还是会用主线程去执行, run()只是Thread类中的普通方法
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).run();
       
    }


    @Test
    public void start() {
        // start会新建线程, 线程的状态是准备状态此时还未获取CUP的时间片
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();

    }


    class Task implements Runnable {

        @Override
        public void run() {

        }
    }

    class Task2 extends Thread {

        @Override
        public void run() {

        }
    }

    class Task3 implements Callable {

        @Override
        public Object call() throws Exception {
            return null;
        }

    }

}
