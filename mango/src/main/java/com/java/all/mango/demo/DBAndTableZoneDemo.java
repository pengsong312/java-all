package com.java.all.mango.demo;

import org.jfaster.mango.annotation.*;
import org.jfaster.mango.sharding.TableShardingStrategy;

/**
 * @ClassName DBAndTableZoneDemo
 * @Description 数据库与数据表分片操作demo
 * @Author ps
 * @Date 2019/2/21 5:22 PM
 * @Version 1.0
 **/
public class DBAndTableZoneDemo {

    public static void main(String[] args) {
    }

    /**
     * 表分片
     */
    public void tableZone() {

    }

    @DB(table = "user")
    @Sharding(tableShardingStrategy = MangoTableShardingStrategy.class)
    interface tableDao {

        @SQL("select * from #table where id = :1")
        User queryById(@TableShardingBy int id);

        @SQL("select * from #table where id = :u.id")
        User queryById(@TableShardingBy("id") @Rename("u") User user);
    }


    class MangoTableShardingStrategy implements TableShardingStrategy<Integer> {
        @Override
        public String getTargetTable(String tablePrefix, Integer id) {
            return tablePrefix.concat("_").concat(id % 3 + "");
        }
    }

}
