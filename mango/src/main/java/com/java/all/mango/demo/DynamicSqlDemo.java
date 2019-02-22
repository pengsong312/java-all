package com.java.all.mango.demo;

import com.java.all.mango.demo.model.User;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import java.util.List;

/**
 * @ClassName DynamicSqlDemo
 * @Description 动态SQL拼接
 * @Author ps
 * @Date 2019/2/22 2:51 PM
 * @Version 1.0
 **/
public class DynamicSqlDemo {

    @DB(table = "user")
    public interface Dao {

        /**
         * @param orderBy 拼接的字符串 #{参数序号}
         */
        @SQL("select userName , password from #table order by #{:1}")
        List<User> getUsers(String orderBy);

        /**
         * if else
         */
        @SQL("select userName , password from #table where #if(:1>0) id=:1 #else id=1001 #end")
        User getUser(int id);

        /**
         * elseif
         */
        @SQL("select userName , password from #table where #if(:1>0) id=:1 #elseif(:1==0) id=1 #else id=-1 #end")
        User getUser2(int id);
    }
}
