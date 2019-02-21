> 在JMM中，如果一个操作执行的结果需要对另一个操作可见，那么这两个操作之间必须存在happens-before关系。

栗子：

```
int i=1;
int j=1;
问：j一定等于1？如果两者之间存在happens-before关系就一定等于1
```
###### 原则规则

```
程序次序规则：一个线程内，按照代码顺序，书写在前面的操作先行发生于书写在后面的操作；
锁定规则：一个unLock操作先行发生于后面对同一个锁额lock操作；
volatile变量规则：对一个变量的写操作先行发生于后面对这个变量的读操作；
传递规则：如果操作A先行发生于操作B，而操作B又先行发生于操作C，则可以得出操作A先行发生于操作C；
线程启动规则：Thread对象的start()方法先行发生于此线程的每个一个动作；
线程中断规则：对线程interrupt()方法的调用先行发生于被中断线程的代码检测到中断事件的发生；
线程终结规则：线程中所有的操作都先行发生于线程的终止检测，我们可以通过Thread.join()方法结束、Thread.isAlive()的返回值手段检测到线程已经终止执行；
对象终结规则：一个对象的初始化完成先行发生于他的finalize()方法的开始
```
###### Happen-Before 推导原理
```
将一个元素放入一个线程安全的队列的操作Happens-Before从队列中取出这个元素的操作
将一个元素放入一个线程安全容器的操作Happens-Before从容器中取出这个元素的操作
在CountDownLatch上的倒数操作Happens-Before CountDownLatch#await()操作
释放Semaphore许可的操作Happens-Before获得许可操作
Future表示的任务的所有操作Happens-Before Future#get()操作
向Executor提交一个Runnable或Callable的操作Happens-Before任务开始执行操作
```

###### Hanppen-Before作用
```
happen-before原则是JMM中非常重要的原则，它是判断数据是否存在竞争、线程是否安全的主要依据，保证了多线程环境下的可见性。
```
