package com.java.all.mango.demo;

/**
 * @ClassName User
 * @Description user entity
 * @Author ps
 * @Date 2019/2/21 5:43 PM
 * @Version 1.0
 **/
public class User {

    private int id;
    private int userName;
    private int password;
    private int address;
    private long createTime;

    public User() {
    }

    public User(int id, int userName, int password, int address, long createTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
