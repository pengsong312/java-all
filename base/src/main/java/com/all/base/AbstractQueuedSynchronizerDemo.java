package com.all.base;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName AbstractQueuedSynchronizerDemo
 * @Description AQS 学习demo
 * @Author ps
 * @Date 2019/1/21 11:44 AM
 * @Version 1.0
 **/
public class AbstractQueuedSynchronizerDemo {
    /**class 锁**/
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        final AbstractQueuedSynchronizerDemo demo = new AbstractQueuedSynchronizerDemo();
        for (int i=0;i<10;i++){
            new Thread(new Runnable() {
                public void run() {
                    demo.demoLock();

                }
            },"thread-"+i).start();
        }
    }

    public void demoLock(){
        lock.lock();
        // do something
        try {
            Thread.sleep(1000L);
            System.out.println("锁定，处理流程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
