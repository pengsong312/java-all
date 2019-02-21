package com.java.all.mango.quickstart.code;

import com.google.gson.Gson;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.transaction.*;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName FruitMangoDemo
 * @Description Fruit ORM 持久使用demo
 * @Author ps
 * @Date 2019/2/21 10:58 AM
 * @Version 1.0
 **/
public class FruitMangoDemo {

    private static final String driverClassName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/mango_example";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {

        DataSource dataSource = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(dataSource);

        FruitMangoDemo demo = new FruitMangoDemo();
        demo.simpleExecute(mango);
        // 事务模版执行
        demo.transcationExecute1(mango);
        // 编程式执行
        demo.transcationExecute2(mango);
    }

    /**
     * 事务操作,事务模版执行
     */
    public void transcationExecute1(final Mango mango) {
        TransactionTemplate.execute(new TransactionAction() {
            @Override
            public void doInTransaction(TransactionStatus transactionStatus) {
                insert(mango);
                int error = 10 / 0;
                query(mango);
            }
        });
    }

    /**
     * 事务操作,编程式执行
     */
    public void transcationExecute2(final Mango mango) {
        Transaction tx = TransactionFactory.newTransaction();
        try {
            insert(mango);
            int error = 10 / 0;
            query(mango);
        } catch (Exception e) {
            tx.rollback();
            System.err.println(e);
            return;
        }
        tx.commit();
    }

    /**
     * 简单操作
     */
    public void simpleExecute(Mango mango) {
        insert(mango);
        query(mango);
    }

    public void insert(Mango mango) {
        if (Objects.isNull(mango)) {
            return;
        }
        FruitDao fruitDao = mango.create(FruitDao.class);
        fruitDao.insert("apple", 100);
        List<Fruit> orange = fruitDao.queryFruitByName("apple");
        System.out.println("添加apple ： " + (orange != null && orange.size() > 0 ? "success" : "fail") + "，查询结果：" + new Gson().toJson(orange));
        fruitDao.insert("orange", 200);
    }

    public void query(Mango mango) {
        if (Objects.isNull(mango)) {
            return;
        }
        FruitDao fruitDao = mango.create(FruitDao.class);
        int sum = fruitDao.sumByName("apple");
        System.out.println("apple sum is " + sum);
    }
}


/**
 * 数据库操作dao
 */
@DB(table = "fruit")
interface FruitDao {

    @ReturnGeneratedId
    @SQL("insert into fruit(name,num) values(:1,:2)")
    int insert(String name, int num);

    @SQL("select * from fruit where name = :1")
    List<Fruit> queryFruitByName(String name);

    @SQL("select sum(num) from #table where name = :1")
    int sumByName(String name);

}