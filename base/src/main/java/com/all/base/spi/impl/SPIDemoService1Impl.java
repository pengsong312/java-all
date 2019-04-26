package com.all.base.spi.impl;

import com.all.base.spi.SPIDemoService;

/**
 * @author: ps
 * @since: 2019/4/15  4:10 PM
 * @version: 1.0.0
 */
public class SPIDemoService1Impl implements SPIDemoService {
    @Override
    public void hello(String word) {
        System.out.println("SPIDemoService1Impl hello() : hello " + word);
    }
}
