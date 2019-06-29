package com.ark.rest.webservices;

public class HelloWorld {

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HelloWorld(String msg) {

        this.msg = msg;
    }

    private String msg;


}
