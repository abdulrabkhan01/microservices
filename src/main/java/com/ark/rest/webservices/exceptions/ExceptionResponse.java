package com.ark.rest.webservices.exceptions;

import java.util.Date;

public class ExceptionResponse {

    private Date time;
    private String msg;
    private String details;

    public ExceptionResponse(Date time, String msg, String details) {
        this.time = time;
        this.msg = msg;
        this.details = details;
    }

    public Date getTime() {

        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
