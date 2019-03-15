package com.all.current;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadPoolExecutorDemo
 * @Description TODO
 * @Author ps
 * @Date 2019/3/11 6:39 PM
 * @Version 1.0
 **/
public class ThreadPoolExecutorDemo {

    private static final AtomicInteger INTEGER = new AtomicInteger(0);
    ThreadPoolExecutor executor = new ThreadPoolExecutor(2,2,0, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));

    public void demo(){
        for(int i=0;i<100;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                }
            });
        }
    }

    public static void main(String[] args) {
        new ThreadPoolExecutorDemo().demo();
    }
}
