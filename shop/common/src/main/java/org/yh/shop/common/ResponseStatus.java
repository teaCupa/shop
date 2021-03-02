package org.yh.shop.common;

import lombok.Getter;

/**
 * @Author: yh
 * @Date: 2020/11/22
 * @Description:
 */

@Getter
public enum  ResponseStatus {
    SUCCESS(200, "操作成功"),

    FAILED(401, "认证失败"),

    FINDERROR(400, "查询操作失败"),

    UPDATEFAIL(400, "更新操作失败"),

    LOGINERROR( 402,"登录失败"),

    LOGOUT( 200,"退出登录"),

//    VALIDATE_FAILED(402, "参数校验失败"),

    ERROR(502, "未知错误");

    private int status;
    private String msg;

    ResponseStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

}
