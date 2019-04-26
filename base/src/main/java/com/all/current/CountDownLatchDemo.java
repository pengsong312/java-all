package com.all.current;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: ps
 * @since: 2019/4/11  1:25 PM
 * @version: 1.0.0
 */
public class CountDownLatchDemo {

    public static final CountDownLatch latch = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {
        System.out.println(0x61c88647);
        char[] chars = "123".toCharArray();
        StringBuffer buffer = new StringBuffer(chars.length);
        for(int i=chars.length-1;i>=0;i--){
            if((int)chars[i] >0){
                buffer.append(chars[i]);
            }
        }

        System.out.println(buffer.toString());

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(new SubThread(latch), "subThread-" + i).start();
        }
        // 主线程等待子线程执行完
        latch.await();
        // 主线程等待子线程执行，设置超时时间（主线程等待时间超时范围内）线程池使用awaitTermination
        latch.await(1000*1, TimeUnit.MILLISECONDS);
        System.out.println("主线程：" + Thread.currentThread().getName() + "等待执行完毕，耗时：" + (System.currentTimeMillis() - start));
    }

    static class SubThread implements Runnable {
        private CountDownLatch latch;

        public SubThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+"线程执行");
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 计数器-1
            latch.countDown();
            System.out.println(Thread.currentThread().getName()+"线程执行完毕");
        }
    }
}
