package com.java.all.mango.demo;

import com.google.gson.Gson;
import com.java.all.mango.demo.model.User;
import org.jfaster.mango.annotation.*;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.sharding.DatabaseShardingStrategy;
import org.jfaster.mango.sharding.ShardingStrategy;
import org.jfaster.mango.sharding.TableShardingStrategy;

import java.util.List;

/**
 * @ClassName DBAndTableZoneDemo
 * @Description 数据库与数据表分片操作demo
 * @Author ps
 * @Date 2019/2/21 5:22 PM
 * @Version 1.0
 **/
public class DBAndTableZoneDemo {

    public static void main(String[] args) {
        new DBAndTableZoneDemo().tableZone();
    }

    /**
     * 表分片
     */
    public void tableZone() {
        Mango mango = new DataSourceClassifyDemo().simpleDataSourceInitMango();
        TableDao dao = mango.create(TableDao.class);
        User user = dao.queryById(1);
        System.out.println("user : " + new Gson().toJson(user));

        User queryUser = new User();
        queryUser.setId(1);
        User user2 = dao.query(queryUser);
        System.out.println("user2 : " + new Gson().toJson(user2));
    }

    /**
     * 库分片
     */
    public void dbZone() {
        Mango mango = new DataSourceClassifyDemo().simpleDataSourceInitMango();
        DBDao dao = mango.create(DBDao.class);

        // TODO: 2019/2/21 your code
    }

    /**
     * 分库又分表
     */
    public void dbAndTableZone() {

    }

    /**
     * 分库
     * 不赋值 数据源名称
     */
    @DB(table = "user")
    @Sharding(databaseShardingStrategy = MangoDBShardingStrategy.class)
    public interface DBDao {
        /**
         * 按照createTime做数据库分库
         */
        @SQL("insert into #table(user_name, password, address,create_time) values(:userName, :password, :address, :createTime)")
        void addUser(@DatabaseShardingBy("createTime") User user);

        @SQL("select id, uid, price, status from t_order where uid = :1")
        List<User> queryUser(@DatabaseShardingBy int id);
    }


    /**
     * 简单分表
     */
    @DB(name = "simple_datasource_mango_init", table = "user")
    @Sharding(tableShardingStrategy = MangoTableShardingStrategy.class)
    public interface TableDao {

        @SQL("select * from #table where id = :1")
        User queryById(@TableShardingBy int id);

        @SQL("select * from #table where id = :u.id")
        User query(@TableShardingBy("id") @Rename("u") User user);
    }


    @DB(table = "user")
    @Sharding(databaseShardingStrategy = MangoDBShardingStrategy.class, tableShardingStrategy = MangoTableShardingStrategy.class)
    public interface DbAndTableDao {
        @SQL("select * from #table where id = :1")
        User queryUserById(@DatabaseShardingBy @TableShardingBy int id);
    }


    @DB(table = "user")
    @Sharding(shardingStrategy = MangoShardingStrategy.class)
    interface Dao {
        @SQL("select * from #table where id = :1")
        User queryUser(@ShardingBy int id);
    }


    /**
     * user分三张表
     */
    static class MangoTableShardingStrategy implements TableShardingStrategy<Integer> {
        @Override
        public String getTargetTable(String tablePrefix, Integer id) {
            return tablePrefix.concat("_").concat(id % 3 + "");
        }
    }


    /**
     * 分库 2个
     */
    static class MangoDBShardingStrategy implements DatabaseShardingStrategy<Integer> {
        @Override
        public String getDataSourceFactoryName(Integer id) {
            return "user_" + id % 2;
        }
    }


    /**
     * 精简分库分表策略
     */
    static class MangoShardingStrategy implements ShardingStrategy<Integer, Integer> {
        @Override
        public String getDataSourceFactoryName(Integer id) {
            return "user_" + id % 2;
        }

        @Override
        public String getTargetTable(String tablePrefix, Integer id) {
            return tablePrefix.concat("_").concat(id % 3 + "");
        }
    }

    /**
     * 还可以实现多纬度分库分表，@Sharding 注解在方法级别，选择不同的分表分库策略
     */

}
