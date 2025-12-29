package com.ritsuki.framework.common.core.exception;

/**
 * 错误码对象
 *
 * @param code    错误码
 * @param message 错误提示
 * @author ritsuki
 */
public record ErrorCode(Long code, String message) {

}

