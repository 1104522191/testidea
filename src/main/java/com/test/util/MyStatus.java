package com.test.util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum MyStatus {
    ERROR(500,"操作失败"),
    SUCCESS(200,"成功"),
    NULLACCOUNT(204,"账号不存在")
    ;


    private  Integer code;
    private  String msg;
//    private Long total;
//    private  Object Data;

}
