package com.java.all.mango.demo;

import com.java.all.mango.demo.model.Message;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.binding.BoundSql;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.interceptor.Parameter;
import org.jfaster.mango.interceptor.QueryInterceptor;
import org.jfaster.mango.interceptor.UpdateInterceptor;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.util.jdbc.SQLType;

import javax.sql.DataSource;
import java.util.List;

/**
 * @ClassName InterceptorDemo
 * @Description Mango 查询与更新 拦截器操作
 * @Author ps
 * @Date 2019/2/22 2:24 PM
 * @Version 1.0
 **/
public class InterceptorDemo {

    public static void main(String[] args) {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

        mango.addInterceptor(new MongoQueryInterceptor());
        // or
        mango.addInterceptor(new MongoUpdateInterceptor());

        MessageDao dao = mango.create(MessageDao.class);
        int uid = 100;
        Message msg = new Message();
        msg.setUid(uid);
        msg.setContent("hello");

        dao.insert(msg);
        dao.getMessages(uid);
    }

    /**
     * 查询拦截器
     */
    static class MongoQueryInterceptor extends QueryInterceptor {
        @Override
        public void interceptQuery(
                BoundSql boundSql, List<Parameter> list, DataSource dataSource) {
            System.out.println("sql = " + boundSql.getSql());
            // your code
        }
    }


    /**
     * 更新拦截器
     */
    static class MongoUpdateInterceptor extends UpdateInterceptor {
        @Override
        public void interceptUpdate(BoundSql boundSql, List<Parameter> list, SQLType sqlType, DataSource dataSource) {
            System.out.println("sql : " + boundSql.getSql());
        }
    }


    @DB
    interface MessageDao {

        @ReturnGeneratedId
        @SQL("insert into message(uid, content) values(:uid, :content)")
        public int insert(Message msg);

        @SQL("select id, uid, content from message where uid=:1")
        public List<Message> getMessages(int uid);

    }
}
