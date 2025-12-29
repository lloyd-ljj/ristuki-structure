package com.ritsuki.framework.common.core.constant;

import com.ritsuki.framework.common.core.exception.ErrorCode;

/**
 * 通用常量：全局错误码
 * 全局错误码枚举 0-999 系统异常编码保留，一般情况下，使用 HTTP 返回状态码
 *
 * @author ritsuki
 */
public interface CommonErrorCodeConst {

    /*************** 成功段 ***************/
    ErrorCode SUCCESS = new ErrorCode(0L, "成功");

    /*************** 客户端错误段 ***************/
    ErrorCode BAD_REQUEST = new ErrorCode(400L, "请求参数不正确");
    ErrorCode UNAUTHORIZED = new ErrorCode(401L, "账号未登录");
    ErrorCode FORBIDDEN = new ErrorCode(403L, "没有该操作权限");
    ErrorCode NOT_FOUND = new ErrorCode(404L, "请求未找到");
    ErrorCode METHOD_NOT_ALLOWED = new ErrorCode(405L, "请求方法不正确");
    ErrorCode LOCKED = new ErrorCode(423L, "请求失败，请稍后重试");
    ErrorCode TOO_MANY_REQUESTS = new ErrorCode(429L, "请求过于频繁，请稍后重试");

    /*************** 服务端错误段 ***************/
    ErrorCode INTERNAL_SERVER_ERROR = new ErrorCode(500L, "网络开小差了，请稍后重试");
    ErrorCode NOT_IMPLEMENTED = new ErrorCode(501L, "功能未实现/未开启");
    ErrorCode ERROR_CONFIGURATION = new ErrorCode(502L, "错误的配置项");
    ErrorCode SHUTDOWN_MAINTAIN = new ErrorCode(503L, "停机维护");
    ErrorCode ENCRYPT_ERROR = new ErrorCode(504L, "加解密异常");

    /*************** 自定义错误段 ***************/
    ErrorCode REPEATED_REQUESTS = new ErrorCode(901L, "重复请求，请稍后重试");
    ErrorCode DEMO_DENY = new ErrorCode(902L, "演示模式，禁止写操作");

    /*************** 兜底错误段 ***************/
    ErrorCode UNKNOWN = new ErrorCode(999L, "未知错误");

}

