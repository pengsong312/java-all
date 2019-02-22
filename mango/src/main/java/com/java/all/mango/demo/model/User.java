package com.java.all.mango.demo.model;

/**
 * @ClassName User
 * @Description user entity
 * @Author ps
 * @Date 2019/2/21 5:43 PM
 * @Version 1.0
 **/
public class User {

    private int id;
    private String userName;
    private String password;
    private String address;
    private long createTime;

    public User() {
    }

    public User(int id, String userName, String password, String address, long createTime) {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
