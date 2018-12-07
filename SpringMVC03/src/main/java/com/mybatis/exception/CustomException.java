package com.mybatis.exception;

/**
 * Created by Administrator on 2017/4/19 0019.
 */
public class CustomException extends Exception{
    //异常信息
    private String messages;

    public CustomException(String message) {
        super(message);
        this.messages = messages;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
