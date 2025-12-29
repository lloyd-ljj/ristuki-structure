package com.ritsuki.framework.common.core.exception;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务逻辑异常
 *
 * @author ritsuki
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private Long code;

    /**
     * 错误提示
     */
    private String message;

    /**
     * 构造函数，通过错误码和错误提示创建 BusinessException 对象
     *
     * @param code    错误码
     * @param message 错误提示
     */
    public BusinessException(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 构造函数，通过 ErrorCode 和可变参数列表创建 BusinessException 对象
     *
     * @param code 错误码
     */
    public BusinessException(ErrorCode code) {
        this.code = code.code();
        this.message = code.message();
    }

    /**
     * 构造函数，通过错误码和错误提示模板以及可变参数列表创建 BusinessException 对象
     *
     * @param code    错误码
     * @param message 错误提示模板
     * @param args    错误提示模板中的变量参数
     * @return BusinessException 对象
     */
    public static BusinessException code(Long code, String message, Object... args) {
        if (args.length == 0) {
            return new BusinessException(code, message);
        }
        return new BusinessException(code, StrUtil.format(message, args));
    }

    /**
     * 构造函数，通过 ErrorCode、错误提示模板以及可变参数列表创建 BusinessException 对象
     *
     * @param code 错误码
     * @param args 错误提示模板中的变量参数
     * @return BusinessException 对象
     */
    public static BusinessException code(ErrorCode code, Object... args) {
        return code(code.code(), code.message(), args);
    }

}

