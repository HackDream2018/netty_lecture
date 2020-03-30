package test.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/3/20
 */
public class CountDownLatchA {

    @Test
    public void test() {
        try {
            CountDownLatch countDownLatch = new CountDownLatch(2);//计数器
            ExecutorService executorService = Executors.newCachedThreadPool();
            Future<Boolean> work1 =  executorService.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    System.out.println("线程1开始执行..........");
                    Thread.sleep(5000);
                    System.out.println("线程1执行完了............");
                    countDownLatch.countDown();
                    return true;
                }
            });
            Future<Boolean> work2 = executorService.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    System.out.println("线程2开始执行..........");
                    Thread.sleep(5000);
                    System.out.println("线程2执行完了............");
                    countDownLatch.countDown();
                    return true;
                }
            });
            Boolean work1Flag =  work1.get();//线程1返回值
            Boolean work2Flag = work2.get();//线程2返回值
            countDownLatch.await();
            System.out.println("运行结果：线程1=" + work1Flag + "线程2=" + work2Flag);
            System.out.println("执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
