package cn.xinghaowlkj.cn.demo.utils.Requst;

import lombok.Getter;

@Getter
public enum ResultEnum implements IResult {
    SUCCESS(1, "接口调用成功"),
    VALIDATE_FAILED(2, "参数校验失败"),
    COMMON_FAILED(3, "接口调用失败"),
    FORBIDDEN(4, "没有权限访问资源");

    private Integer code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}