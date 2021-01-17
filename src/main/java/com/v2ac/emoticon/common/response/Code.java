package com.v2ac.emoticon.common.response;

/**
 * 错误码表.
 */
public enum Code {
    /* 1024以内, 同HTTP */
    SUCCESS(200, "Success"),
    NOT_FOUND(404, "Not Found"),

    /* 通用错误码 */
    PUB_PARAM_ERROR(3000, "非法参数"),
    PUB_PARAM_WRONG(3001, "参数错误"),
    PUB_SERVICE_EXCEPTION(4000, "服务异常"),

    /*文件错误码*/
    FILE_UPLOAD_ERR(5000, "上传文件失败"),
    FILE_UPLOAD_NULL(5001, "上传文件为空"),

    ;

    private long code;
    private String message;

    Code(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
