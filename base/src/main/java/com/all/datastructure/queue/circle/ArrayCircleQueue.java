package com.all.datastructure.queue.circle;

import com.all.datastructure.queue.Queue;

/**
 * @ClassName ArrayCircleQueue
 * @Description 数组循环队列
 * @Author ps
 * @Date 2019/2.jpg/28 11:15 AM
 * @Version 1.jpg.0
 **/
public class ArrayCircleQueue implements Queue<Object> {

    /**
     * 存储数据的数组
     */
    private transient Object[] iterm;

    /**
     * 数组元素大小
     */
    private transient int capcity;
    /**
     * 当前数组中的元素个数
     */
    private transient int size;
    /**
     * 头节点下标
     */
    private int head;
    /**
     * 尾节点的下个节点下标，使用一个null节点优化存储结构
     */
    private int tail;

    public ArrayCircleQueue(int capcity) {
        this.iterm = new Object[capcity];
        this.capcity = capcity;
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public Boolean enQueue(Object o) {
        // 队满(队头==队尾的下一个元素地址)，不允许插入
        if (head == (tail + 1) % capcity) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }

        iterm[tail] = o;
        size++;
        tail = (tail + 1) % capcity;
        return true;
    }

    @Override
    public Object deQueue() {
        // 对空
        if (head == tail) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        Object result = iterm[head];
        iterm[head] = null;
        head = (head + 1) % capcity;
        size--;
        return result;
    }

    public static void main(String[] args) {
        ArrayCircleQueue q = new ArrayCircleQueue(4);
        System.out.println(q.enQueue("张三"));
        System.out.println(q.enQueue("李斯"));
        System.out.println(q.enQueue("赵五"));
        System.out.println(q.enQueue("王一"));

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true){
                    System.out.println(q.enQueue("value = "+i));
                    i++;
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(q.deQueue());
                }
            }
        }).start();
    }
}
