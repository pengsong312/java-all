package com.all.datastructure.queue;

/**
 * @ClassName Queue
 * @Description 队列操作接口
 * @Author ps
 * @Date 2019/2.jpg/28 11:21 AM
 * @Version 1.0
 **/
public interface Queue<E> {

    Boolean enQueue(E e);

    E deQueue();
}
