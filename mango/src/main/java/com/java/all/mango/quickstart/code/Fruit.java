package com.java.all.mango.quickstart.code;

/**
 * @ClassName Fruit
 * @Description TODO
 * @Author ps
 * @Date 2019/2/21 11:24 AM
 * @Version 1.0
 **/
public class Fruit {
    private int id;
    protected String name;
    private int num;

    public Fruit() {
    }

    public Fruit(int id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}