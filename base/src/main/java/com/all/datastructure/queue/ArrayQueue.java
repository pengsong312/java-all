package com.all.datastructure.queue;

/**
 * @ClassName ArryQueue
 * @Description 基于数组实现一个队列 队列 FIFO
 * @Author ps
 * @Date 2019/2.jpg/27 10:36 AM
 * @Version 1.jpg.0
 **/
public class ArrayQueue {

    /**
     * 数组大小
     */
    private static final int capcity = 10;
    /**
     * 数据存储的数组，简单的存储，不支持动态扩容
     */
    private transient Object[] iterm = new Object[10];
    /**
     * 当前数组中元素个数
     */
    private transient int size;
    /**
     * 队头数组下标
     */
    private int head;
    /**
     * 对尾数组下标
     */
    private int tail;

    public ArrayQueue() {
    }

    /**
     * 从队尾插入
     *
     * @param obj 入队的元素
     * @return true 入队成功 false 入队失败
     */
    public boolean enQueue(Object obj) {
        // 队满、禁止插入
        if ((head == 0) && (tail == capcity)) {
            return false;
        }
        // 数据搬移
        if (head != 0 && tail == capcity) {
            for (int i = head; i < tail; i++) {
                iterm[i - head] = iterm[i];
            }
            tail = tail - head;
            head = 0;
        }
        iterm[tail++] = obj;
        size++;
        return true;
    }

    /**
     * 出队 队头
     *
     * @return 队头元素
     */
    public Object outQueue() {
        Object result = null;
        if (head == tail) {
            return result;
        }
        // 直接取head下标元素，且head+1.jpg
        result = iterm[head++];
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(queue.enQueue("obj_" + i));
                }
            }
        }, "thread-enqueue").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(queue.outQueue()+" , size = "+ queue.size());
                }
            }
        }, "thread-enqueue").start();
    }
}
