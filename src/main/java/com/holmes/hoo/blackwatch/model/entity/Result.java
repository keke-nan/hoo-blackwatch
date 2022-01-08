package com.holmes.hoo.blackwatch.model.entity;

import com.holmes.hoo.blackwatch.common.Code;
import org.apache.http.HttpStatus;

import java.io.Serializable;

/**
 * @author A20019
 * @since 2022/1/8 10:39
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -9120721239942303550L;
    private T data;
    private Integer code;
    private String message;

    public static <T> Result<T> ofFailed(Code code) {
        Result<T> result = new Result<>();
        result.code = code.getCode();
        result.message = code.getMessage();
        return result;
    }

    public static <T> Result<T> ofFailed(Code code, String message) {
        Result<T> result = new Result<>();
        result.code = code.getCode();
        result.message = message;
        return result;
    }

    public static <T> Result<T> ofSucceed() {
        Result<T> result = new Result<>();
        result.code = HttpStatus.SC_OK;
        result.message = "successful";
        return result;
    }

    public static <T> Result<T> ofSucceed(T data) {
        Result<T> result = new Result<>();
        result.data = data;
        result.code = HttpStatus.SC_OK;
        result.message = "successful";
        return result;
    }

    public Result() {
    }

    public T getData() {
        return this.data;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

}
