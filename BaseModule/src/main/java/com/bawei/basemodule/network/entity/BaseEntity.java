package com.bawei.basemodule.network.entity;

public class BaseEntity<T> {


    /**
     * code : 200
     * data : {"id":73,"username":"aaa","pwd":"aaa","sex":"2","birthday":"saa","headerimg":"saa6","nick":"samplea 7","utype":8}
     * msg : 操作成功
     */

    private int code;
    private T data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
    }
}
