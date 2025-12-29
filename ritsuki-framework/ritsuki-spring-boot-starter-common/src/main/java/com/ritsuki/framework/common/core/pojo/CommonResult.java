package com.ritsuki.framework.common.core.pojo;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.ritsuki.framework.common.core.constant.CommonErrorCodeConst;
import com.ritsuki.framework.common.core.exception.ErrorCode;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 通用类：公共返回结果类
 *
 * @author ritsuki
 */
@Data
public class CommonResult<T> {

    /**
     * 状态码
     */
    public Long code;

    /**
     * 错误信息
     */
    public String message;

    /**
     * 当前时间
     */
    public String current = LocalDateTimeUtil.format(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");

    /**
     * 返回的数据
     */
    public T data;

    /**
     * 构造函数，使用默认的错误码创建一个CommonResult对象
     */
    public CommonResult() {
        this(CommonErrorCodeConst.SUCCESS);
    }

    /**
     * 构造函数，通过指定的状态码、错误信息和数据构建一个CommonResult对象
     *
     * @param code 状态码
     * @param data 返回的数据
     */
    public CommonResult(ErrorCode code, T data) {
        this.code = code.code();
        this.message = code.message();
        this.data = data;
    }

    /**
     * 构造函数，通过指定的状态码构建一个CommonResult对象
     *
     * @param code 状态码
     */
    public CommonResult(ErrorCode code) {
        this(code, null);
    }

    /**
     * 构造函数，通过指定的状态码、错误信息和数据构建一个CommonResult对象
     *
     * @param code    状态码
     * @param message 错误信息
     * @param data    返回的数据
     */
    public CommonResult(Long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 构造函数，通过指定的状态码、错误信息和数据构建一个CommonResult对象
     *
     * @param code    状态码
     * @param message 错误信息
     */
    public CommonResult(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 创建一个成功状态的CommonResult对象，数据为空
     *
     * @param data 返回的数据
     * @param <T>  返回的数据类型
     * @return CommonResult对象
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(CommonErrorCodeConst.SUCCESS, data);
    }

    /**
     * 创建一个成功状态的CommonResult对象，数据为空
     *
     * @return CommonResult对象
     */
    public static <T> CommonResult<T> success() {
        return new CommonResult<>(CommonErrorCodeConst.SUCCESS);
    }

}

