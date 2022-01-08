package com.holmes.hoo.blackwatch.model.entity;

import java.io.Serializable;

/**
 * @author A20019
 * @since 2022/1/8 17:17
 */
public class AliResult<T> implements Serializable {
    private static final long serialVersionUID = -9083852413764731960L;

    private T result;

    private String status;

    private String msg;

    public AliResult() {
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
