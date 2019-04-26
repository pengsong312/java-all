package com.all.locks;

/**
 * @author: ps
 * @since: 2019/4/11  5:53 PM
 * @version: 1.0.0
 * 验证锁的作用域：
 * 1 锁实例对象，是否锁实例对象下的属性
 * 2 锁对象下的属性，是否锁实例对象
 * 3 静态和非静态方法锁的所用域
 * 4 锁类是否锁住类的所有对象
 * 5 锁类的静态变量是否锁类
 */
public class SynchronizedScope {

    public final static Object OBJECT = new Object();
    private int number1;
    private static int number2;

    public void incrNumber1() {
        for (int i = 0; i < 10; i++) {
            number1++;
        }
        System.out.println(number1);

    }

    public static void incrNumber2() {
        for (int i = 0; i < 10; i++) {
            number2++;
        }
        System.out.println(number2);
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedScope synchronizedScope = new SynchronizedScope();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
//                incrNumber2();
                synchronizedScope.incrNumber1();
            }, "" + i);
            thread.start();
//            thread.join();
        }



        // 锁实例对象，验证该类的静态变量线程安全
        //        execute(synchronizedScope);
        //        System.out.println("锁实例对象，验证该类的静态变量线程安全 : 成员number1 = "+synchronizedScope.number1 +" , 静态number2 = "+number2);
        //
        //        execute(synchronizedScope);
        //        System.out.println("锁实例对象，验证该实例的成员变量线程安全 : 成员number1 = "+synchronizedScope.number1 +" , 静态number2 = "+number2);
        //
        //        execute(synchronizedScope);
        //        System.out.println("锁类的静态变量，验证实例的成员变量线程安全 : 成员number1 = "+synchronizedScope.number1 +" , 静态number2 = "+number2);
        //
        //        execute(synchronizedScope);
        //        System.out.println("锁类的静态变量，验证该类的静态变量线程安全 : 成员number1 = "+synchronizedScope.number1 +" , 静态number2 = "+number2);

    }


    static void execute(SynchronizedScope synchronizedScope) throws InterruptedException {
        int maxThreads = 888;
        for (int i = 0; i < maxThreads; i++) {
            new Thread(new NumberRunnable1(synchronizedScope), "Runnable-" + i).start();
        }
    }

}


/**
 * 锁实例对象时：该类的静态变量线程安全
 */
class NumberRunnable1 implements Runnable {

    private SynchronizedScope synchronizedScope;

    public NumberRunnable1(SynchronizedScope synchronizedScope) {
        this.synchronizedScope = synchronizedScope;
    }

    @Override
    public void run() {
        // 锁实例对象
        //        synchronized (synchronizedScope) {
        // 验证类的静态变量
        SynchronizedScope.incrNumber2();
        //        }
    }
}


/**
 * 锁实例对象时：该类的静态变量线程安全
 */
class NumberRunnable2 implements Runnable {

    private SynchronizedScope synchronizedScope;

    public NumberRunnable2(SynchronizedScope synchronizedScope) {
        this.synchronizedScope = synchronizedScope;
    }

    @Override
    public void run() {
        // 锁实例对象
        synchronized (synchronizedScope) {
            // 验证类的静态变量
            synchronizedScope.incrNumber1();
        }
    }
}


/**
 * 锁类静态变量：该类的静态变量线程安全
 */
class NumberRunnable3 implements Runnable {

    private SynchronizedScope synchronizedScope;

    public NumberRunnable3(SynchronizedScope synchronizedScope) {
        this.synchronizedScope = synchronizedScope;
    }

    @Override
    public void run() {
        // 锁实例对象
        synchronized (SynchronizedScope.OBJECT) {
            // 验证类的静态变量
            synchronizedScope.incrNumber1();
        }
    }
}


/**
 * 锁类静态变量：该类的静态变量线程安全
 */
class NumberRunnable4 implements Runnable {

    private SynchronizedScope synchronizedScope;

    public NumberRunnable4(SynchronizedScope synchronizedScope) {
        this.synchronizedScope = synchronizedScope;
    }

    @Override
    public void run() {
        // 锁实例对象
        synchronized (SynchronizedScope.OBJECT) {
            // 验证类的静态变量
            SynchronizedScope.incrNumber2();
        }
    }
}