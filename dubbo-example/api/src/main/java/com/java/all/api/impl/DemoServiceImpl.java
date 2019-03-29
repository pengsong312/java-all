package com.java.all.api.impl;

import com.java.all.api.DemoService;

/**
 * @author: ps
 * @version: 1.0.0
 * @since: 2019/3/29  5:57 PM
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String say(String var) {
        return "Hello ".concat(var);
    }
}
