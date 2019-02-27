package com.java.all.mango.demo;

import com.java.all.mango.demo.model.Teacher;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

/**
 * @ClassName FunctionConvertDemo
 * @Description 函数式调用demo
 * @Author ps
 * @Date 2019/2/22 5:44 PM
 * @Version 1.0
 **/
public class FunctionConvertDemo {

    @DB
    public interface TeacherDao {
        @ReturnGeneratedId
        @SQL("insert into teacher(name, student_ids) values(:name, :studentIds)")
        int addTeacher(Teacher t);

        @SQL("select id, name, student_ids from teacher where id = :1")
        Teacher getTeacherById(int id);

    }

}
