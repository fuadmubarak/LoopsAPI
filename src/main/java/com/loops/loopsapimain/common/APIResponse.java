package com.loops.loopsapimain.common;

public class APIResponse {

    private Integer status;
    private Object data;
    private Object error;
//    private Object userCred;


    //constructor

//    public APIResponse(Integer status, Object data, Object error) {
//        this.status = 200;
//        this.data = data;
//        this.error = error;
//    }
//
//    public APIResponse(Integer status) {
//        this.status = status;
//    }

    public APIResponse() {
        this.status = 200;
        this.data = data;
        this.error = error;

    }


    //getter setter

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    //getset userCrec

//
//    public Object getUserCred() {
//        return userCred;
//    }
//
//    public void setUserCred(Object userCred) {
//        this.userCred = userCred;
//    }
}
