package com.wayzim.entity.result;

import lombok.Getter;

/**
 * @author sunliliang
 * @date 23/03/2020 - 16:41
 * @description
 */
@Getter
public enum  ResultCode {
    /**
     * 操作成功
     */
    SUCCESS(true,10000,"操作成功"),

    /**
     * 操作失败
     */
    FAIL(false,10001,"操作失败");

    /**
     * 操作是否成功
     */
    boolean success;

    /**
     * 操作码
     */
    int code;

    /**
     * 提示信息
     */
    String message;

    ResultCode(boolean success,int code,String message){
        this.success=success;
        this.code=code;
        this.message=message;
    }
}
