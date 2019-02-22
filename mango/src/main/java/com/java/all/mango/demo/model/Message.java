package com.java.all.mango.demo.model;

/**
 * @ClassName Message
 * @Description TODO
 * @Author ps
 * @Date 2019/2/22 2:25 PM
 * @Version 1.0
 **/
public class Message {

    private int id;
    private int uid;
    private String content;

    public Message() {
    }

    public Message(int id, int uid, String content) {
        this.id = id;
        this.uid = uid;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
