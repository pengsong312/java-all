package com.all.locks;

/**
 * @author: ps
 * @since: 2019/4/11  7:35 PM
 * @version: 1.0.0
 */
public class UnsafeSequence {

    private int value;

    public int getValue() {
        return value++;
    }

    public static void main(String[] args) throws InterruptedException {

        final UnsafeSequence us = new UnsafeSequence();
        for(int i = 0;i< 1000;i++){
            Thread thread = new Thread("th"+i) {
                @Override
                public void run() {
                    System.out.println( us.getValue()+" "+super.getName());
                }
            };
            thread.start();
        }

        /**
         * 如果不執行Thread.sleep(1000);
         * 偶尔結果为：
         * 0 th2
         * 0 th1
         * 如果执行Thread.sleep(1000);
         * 结果为：
         * 0 th1
         * 1 th2
         */
    }
}