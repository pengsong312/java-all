package com.java.all.dubbo270.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.java.all.dubbo270.provider.DemoService;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName DemoServiceImpl
 * @Description demoService 实现类
 * @Author ps
 * @Date 2019/2/25 11:56 AM
 * @Version 1.0
 **/
@Service()
public class DemoServiceImpl implements DemoService {

    @Override
    public String demo(String name) {
        if (StringUtils.isBlank(name)) {
            return "hello default";
        }
        return "hello ".concat(name);
    }
}
