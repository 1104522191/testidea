package com.test.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JsonResponseStatus {
    SUCCESS(200,"成功"),
    ERROR(100,"失败"),
    NULLACCOUNT(204,"账号不存在"),
    PWDERROR(205,"密码错误"),
    ACCOUNTEXISTS(201,"账号已存在"),
    CREATEMENUFAILE(1001,"菜单不存在"),
    QUERYBYPAGEFAILE(301,"分页查询失败"),
    ADDERROR(401,"新增失败"),
    DELETERROR(501,"删除失败"),
    ;

    private Integer code;
    private String msg;
}
