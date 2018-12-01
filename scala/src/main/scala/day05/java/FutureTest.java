package day05.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

    public static void main(String[] args) throws Exception {
        // TODO Java中Future的使用 - 线程高效执行
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Future<String> future = cachedThreadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println("线程执行完成");
                return "执行成功";
            }
        });
        // 直接调用get方法会进入阻塞状态 -> 执行完毕后其他线程正常执行
        // String message = future.get();
        // System.out.println(message);
        // 设定最大等待时长：2000,如果在规定时间内线程没有执行完毕，返回失败的信息 -> 业务逻辑在两秒钟之内完成(正常完成时间为1秒)
        Thread.sleep(1000);
        System.out.println("已等待1秒");
        String msg = "";
        if (future.isDone()){
            msg = "正常执行";
        }else {
            Thread.sleep(1000);
            if (!future.isDone()){
                msg = "等待超时";
                future.cancel(true);
                // 如果一个线程已经被取消/杀死，此时无返回值，调用会发生异常
                if (future.isDone()){// 判断线程是否已结束(completed) -> cancel标记为结束
                    try {
                        msg = future.get();
                    }catch (Exception e){
                        msg = "运行时异常终止";
                    }
                }
                // future.get();
            }else {
                // 如果线程已经完成，可以马上拿到返回结果
                msg = future.get();
            }
        }
        System.out.println(msg);
        // 使用shutdown方法等待所有线程完成后关闭
        cachedThreadPool.shutdown();
    }
}
