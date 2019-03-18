package com.java.all.spring.ioc.pojo;

import lombok.*;

/**
 * @ClassName IOCPojo
 * @Description IOC pojo 实体类
 * @Author ps
 * @Date 2019/3/18 2:23 PM
 * @Version 1.0
 **/
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IOCPojo {
    private int id;
    private String applicationName;
    private Node nodes;
}
