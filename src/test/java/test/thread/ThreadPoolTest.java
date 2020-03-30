package test.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/3/18
 */
public class ThreadPoolTest {

    @Test
    public void execute() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Task());
    }


    /**
     * 使用线程池执行Callable任务
     */
    @Test
    public void submit()throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<FutureTask> futureTasks = new ArrayList<>();
        // 循环体内创建多个任务, 将多个任务交线程池来执行
        for(int i = 0; i <= 1; i++) {
            FutureTask task = new FutureTask(new Task2());
            futureTasks.add(task);
            executorService.submit(task);
        }

        futureTasks.forEach(x -> {
            try {
                System.out.println(x.get());
            }catch (Exception e) {}
        });
    }

    class Task implements Runnable {
        @Override
        public void run() {
             System.out.println("任务无返回值");
        }
    }

    class Task2 implements Callable {
        @Override
        public Object call() throws Exception {
            return "任务有返回值";
        }
    }

}
