package org.drools.spring.demo.simple;

/**
 * Created by Administrator on 2016/7/14.
 */
public class Message {
    //常量 HELLO 值0
    public static final int HELLO = 0;
    //常量 GOODBYE 值0
    public static final int GOODBYE = 1;


    //消息
    private String message;
    //状态
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
