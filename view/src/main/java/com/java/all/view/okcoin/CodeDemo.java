package com.java.all.view.okcoin;

import com.java.all.view.kuaishou.FileDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ps
 * @since: 2019/4/28  11:08 AM
 * @version: 1.0.0
 */
public class CodeDemo {

    public static void main(String[] args) {
        Map<FileDemo,FileDemo>  map = new HashMap<>(3);

        FileDemo demo1 = new FileDemo();
        FileDemo demo2 = new FileDemo();
        FileDemo demo3 = new FileDemo();

        map.put(demo1,demo1);
        map.put(demo2,demo2);
        map.put(demo3,demo3);

        System.out.println(map.size());
    }
}

class Demo{
    private int code;
    private String name;

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
