package com.ola.common.utils;

import com.ola.common.enums.BaseExceptionEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResultData<T> implements Serializable {

    private int code = 200;

    private String msg = "请求成功";

    private T data;

    /**
     * 成功状态默认结果
     */
    public ResultData() {
        super();
    }

    /**
     * 自定义异常返回
     *
     */
    public ResultData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 成功状态返回数据
     *
     */
    public ResultData(T data) {
        super();
        this.data = data;
    }

    public ResultData(BaseExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getDesc();
    }
}
