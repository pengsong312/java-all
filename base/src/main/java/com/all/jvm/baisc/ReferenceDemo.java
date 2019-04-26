package com.all.jvm.baisc;

import java.lang.ref.SoftReference;

/**
 * @author: ps
 * @since: 2019/4/23  6:00 PM
 * @version: 1.0.0
 */
public class ReferenceDemo {

    public static void main(String[] args) {
        SoftReference[] softArr = new SoftReference[5];
        softArr[0] = new SoftReference<byte[]>(new byte[1024*1024*2]);
        System.out.println("GC 前===>"+softArr[0].get());
        System.gc();
        System.out.println("第一次GC后：===>"+softArr[0].get());
        softArr[1] = new SoftReference<byte[]>(new byte[1024*1024*2]);
        System.gc();
        System.out.println("第二次GC后===>"+softArr[0].get());
        softArr[2] = new SoftReference<byte[]>(new byte[1024*1024*2]);
        System.gc();
        System.out.println("第三次GC后===>"+softArr[0].get());
        softArr[3] = new SoftReference<byte[]>(new byte[1024*1024*2]);
        //System.gc();  这里都不需要显示执行，因为堆内存已经满了，虚拟机自己会执行。
        System.out.println("第四次GC后===>"+softArr[0].get());
    }
}
