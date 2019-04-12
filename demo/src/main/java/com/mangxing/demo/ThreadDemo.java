package com.mangxing.demo;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ 作者 CODE_LYF
 * @ 时间   2019/4/8.
 * 代码人生
 */
public class ThreadDemo {

    public static void main(String[] args) {

        //创建一个容量为5额的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 15; i++) {
            //向线程池提交一个任务
            executorService.execute(new TextRunnable());
            // Log.d("测试","-------"+i);
            System.out.println("测试-------" + i);
        }
        executorService.shutdown();

    }

    static class TextRunnable extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(1000 * 6);
               // ArrayList<Object> objects = new ArrayList<>();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("测试-------" + Thread.currentThread().getName() + "线程被调用了");
        }
    }
}
