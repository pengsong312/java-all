package com.java.all.mango.demo.model;

import org.jfaster.mango.annotation.Getter;
import org.jfaster.mango.annotation.Setter;
import org.jfaster.mango.invoker.function.IntegerListToStringFunction;
import org.jfaster.mango.invoker.function.StringToIntegerListFunction;
import org.jfaster.mango.invoker.function.enums.EnumToIntegerFunction;
import org.jfaster.mango.invoker.function.enums.IntegerToEnumFunction;
import org.jfaster.mango.invoker.function.json.GsonToObjectFunction;
import org.jfaster.mango.invoker.function.json.ObjectToGsonFunction;

import java.util.List;

/**
 * @ClassName Teacher
 * @Description 老师entity Getter & Setter
 * 注解用户函数式类型转换 具体转换类型和方法见：org.jfaster.mango.invoker.function
 * @Author ps
 * @Date 2019/2/22 5:47 PM
 * @Version 1.0
 **/
public class Teacher {

    private int id;

    private String name;

    private Gender gender;

    /**
     * 学生学号ID列表
     */
    private List<Integer> studentIds;

    private SubCard subCard;

    public Teacher() {
    }

    public Teacher(int id, String name, List<Integer> studentIds) {
        this.id = id;
        this.name = name;
        this.studentIds = studentIds;
    }

    // id与name属性对应的get与set方法必须加上，这里省略掉了

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Getter(IntegerListToStringFunction.class)
    public List<Integer> getStudentIds() {
        return studentIds;
    }

    @Setter(StringToIntegerListFunction.class)
    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }

    @Getter(EnumToIntegerFunction.class)
    public Gender getGender() {
        return gender;
    }

    @Setter(IntegerToEnumFunction.class)
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Getter(ObjectToGsonFunction.class)
    public SubCard getSubCard() {
        return subCard;
    }

    @Setter(GsonToObjectFunction.class)
    public void setSubCard(SubCard subCard) {
        this.subCard = subCard;
    }


    enum Gender {

        MALE, FEMALE

    }

    class SubCard {

        private int type;

        private String content;

        // type与content属性对应的get与set方法必须加上，这里省略掉了

    }
}
