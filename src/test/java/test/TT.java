package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    public static void main(String[] args)throws Exception {

        // 线程安全的计数器
        AtomicInteger totalRows = new AtomicInteger(0);

        // 创建线程池，其中核心线程10，也是我期望的最大并发数，最大线程数和队列大小都为30，即我的总任务数
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 30, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(30));

        // 初始化CountDownLatch，大小为30
        CountDownLatch countDownLatch = new CountDownLatch(30);

        // 模拟遍历参数集合
        for (int i = 0; i < 30; i++) {
            // 往线程池提交任务
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        int times = 0;
                        // 模拟数据拉取过程可能需要分页
                        while (true) {
                            // 模拟每个任务需要分页5次
                            if (times >= 5) {
                                break;
                            }
                            times++;

                            // 模拟计数
                            totalRows.incrementAndGet();
                            // 模拟耗时
                            Thread.sleep(Long.valueOf(String.valueOf(new Double(Math.random() * 1000).intValue())));
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        // 子线程任务跑完了, 调用countDown()标识线程完毕, 配合await()表示等待所有子线程执行完后再统一放行
                        countDownLatch.countDown();
                    }
                }
            });
            // 打印线程池运行状态
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行结束的任务数目：" + executor.getCompletedTaskCount());
        }
        // 标记多线程关闭，但不会立马关闭
        executor.shutdown();

        // 阻塞当前线程，直到所有子线程都执行countDown方法才会继续执行
        countDownLatch.await();

        // 打印线程池运行状态
        System.out.println("线程池中线程数目结果：" + executor.getPoolSize() + "，队列中等待执行的任务数目结果：" +
                executor.getQueue().size() + "，已执行结束的任务数目结果：" + executor.getCompletedTaskCount());

        // 打印计数
        System.out.println("结束：" + totalRows.get());

    }



}