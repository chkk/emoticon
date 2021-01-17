package com.v2ac.emoticon.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 接口返回值格式定义.
 * 接口返回均为JSON格式, 形式为: {code: XXX, message:, YYY, data: ZZZ}
 * 其中code为错误码, message为简单的错误描述, data为请求成功时返回的所需数据.
 * 注意: message不能作为前端显示错误的凭据, 该值仅为开发调试使用.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    private long code;
    private String message;
    private T data;

    public static <T> Response<T> ok() {
        return ok(Code.SUCCESS, null);
    }

    public static <T> Response<T> ok(T data) {
        return ok(Code.SUCCESS, data);
    }

    private static <T> Response<T> ok(Code code, T data) {
        return new Response<>(code, data);
    }

    public static <T> Response<T> error(Code code) {
        return ok(code, null);
    }

    public Response() {
    }

    public Response(T data) {
        this(Code.SUCCESS, data);
    }

    public Response(Code code) {
        this(code.getCode(), code.getMessage(), null);
    }

    private Response(Code code, T data) {
        this(code.getCode(), code.getMessage(), data);
    }

    private Response(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
