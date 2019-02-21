package com.java.all.mango.conf;

/**
 * @ClassName DataSourceConstants
 * @Description 数据源常量
 * @Author ps
 * @Date 2019/2/21 1:54 PM
 * @Version 1.0
 **/
public class DataSourceConstants {

    public static class DataSource{
        public static final String driverClassName = "com.mysql.jdbc.Driver";
        public static final String url = "jdbc:mysql://127.0.0.1:3306/mango_example";
        public static final String username = "root";
        public static final String password = "root";
    }
}
