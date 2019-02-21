package com.java.all.mango.demo;

import com.google.common.collect.Lists;
import com.java.all.mango.conf.DataSourceConstants;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.datasource.DataSourceFactory;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.datasource.MasterSlaveDataSourceFactory;
import org.jfaster.mango.datasource.SimpleDataSourceFactory;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName DataSourceClassifyDemo
 * @Description 数据源多种方式的分类配置
 * @Author ps
 * @Date 2019/2/21 1:53 PM
 * @Version 1.0
 **/
public class DataSourceClassifyDemo {

    /**
     * 单一数据库mango初始化方法
     */
    public Mango simpleDataSourceInitMango() {
        String simpleName = "simple_datasource_mango_init";
        DataSource simple = simple();
        DataSourceFactory factory = simpleDataSourceFactory(simpleName, simple);
        Mango mango = Mango.newInstance(factory);

        return mango;
    }

    /**
     * 主从数据库mango初始化方法
     */
    public Mango masterAndSlaveDataSourceInitMango() {
        String name = "master_slaves_datasource_mango_init";
        //  写请求路由到master
        DataSource master = master();
        List<DataSource> slaves = slaves();
        DataSourceFactory factory = masterAndSlavesDataSourceFactory(name, master, slaves);
        Mango mango = Mango.newInstance(factory);

        return mango;
    }

    public Mango mixDataSourceInitMango() {
        String name = "master_slaves_datasource_mango_init";
        DataSource master = master();
        List<DataSource> slaves = slaves();
        DataSourceFactory masterAndSlavesFactory = masterAndSlavesDataSourceFactory(name, master, slaves);

        String simpleName = "simple_datasource_mango_init";
        DataSource simple = simple();
        DataSourceFactory simpleFactory = simpleDataSourceFactory(simpleName, simple);
        Mango mango = Mango.newInstance((DataSourceFactory) Arrays.asList(masterAndSlavesFactory, simpleFactory));
        return mango;
    }

    public DataSourceFactory simpleDataSourceFactory(String name, DataSource dataSource) {
        return new SimpleDataSourceFactory(name, dataSource);
    }

    public DataSourceFactory masterAndSlavesDataSourceFactory(String name, DataSource master, List<DataSource> slaves) {
        return new MasterSlaveDataSourceFactory(name, master, slaves);
    }

    public DataSource simple() {
        //  读写请求路由
        DataSource simple = new DriverManagerDataSource(
                DataSourceConstants.DataSource.driverClassName,
                DataSourceConstants.DataSource.url,
                DataSourceConstants.DataSource.username,
                DataSourceConstants.DataSource.password);
        return simple;
    }

    public DataSource master() {
        //  写请求路由到master
        DataSource master = new DriverManagerDataSource(
                DataSourceConstants.DataSource.driverClassName,
                DataSourceConstants.DataSource.url,
                DataSourceConstants.DataSource.username,
                DataSourceConstants.DataSource.password);
        return master;
    }

    public List<DataSource> slaves() {
        //  读请求路由到master
        DataSource slave = new DriverManagerDataSource(
                DataSourceConstants.DataSource.driverClassName,
                DataSourceConstants.DataSource.url,
                DataSourceConstants.DataSource.username,
                DataSourceConstants.DataSource.password);

        List<DataSource> slaves = Lists.newArrayList(slave);
        return slaves;
    }

    /**
     * name DataSourceFactory 工厂的名字，使用该名称的数据源实例
     * table 数据库表名
     */
    @DB(name = "master_slaves_datasource_mango_init", table = "table")
    interface masterAndSlavesDao {

        /**
         * 写操作作用在master节点上
         */
        @SQL("insert into #table values(:1.id)")
        int insert(Object o);

        /**
         * 读操作随机选择slaves从库节点操作
         */
        @SQL("select * from #table")
        List<Object> query();
    }


    /**
     * name DataSourceFactory 工厂的名字，使用该名称的数据源实例
     * table 数据库表名
     */
    @DB(name = "simple_datasource_mango_init")
    interface simpleDao {

    }
}
