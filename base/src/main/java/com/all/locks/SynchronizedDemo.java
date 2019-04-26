package com.all.locks;

/**
 * @author: ps
 * @since: 2019/4/11  10:55 AM
 * @version: 1.0.0
 */
public class SynchronizedDemo {

    public static final Object lock = new Object();

    public static int count;

    public void incr(){
        synchronized (lock){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Runnable sub1 = new SubThread();
        Runnable sub2 = new SubThread();
        Thread thread1 = new Thread(sub1);
        thread1.start();
        Thread thread2 = new Thread(sub2);
        thread2.start();
        // 主线程等待子线程执行完毕，可使用CountDownLatch
        thread1.join();
        thread2.join();


        System.out.println("count = "+ SynchronizedDemo.count);
    }

    static class SubThread implements Runnable{

        public SubThread() {
        }

        @Override
        public void run() {
            for(int i = 0;i<10000;i++){
                new SynchronizedDemo().incr();
            }
        }
    }

}
