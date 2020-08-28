package com.wayzim.entity.result;

import lombok.Data;

/**
 * @author sunliliang
 * @date 27/08/2020 - 16:47
 * @description
 */
@Data
public class Result {

    /**
     * 操作是否成功
     */
    private boolean success;

    /**
     * 操作码
     */
    private int code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 数据
     */
    private Object data;

    public Result(ResultCode code){
        this.success=code.success;
        this.code=code.code;
        this.message=code.message;
    }

    public Result(ResultCode code,Object data){
        this.success=code.success;
        this.code=code.code;
        this.message=code.message;
        this.data=data;
    }

    public static Result SUCCESS(){
        return new Result(ResultCode.SUCCESS);
    }

    public static Result FAIL(){
        return new Result(ResultCode.FAIL);
    }
}
