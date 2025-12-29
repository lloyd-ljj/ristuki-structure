package com.ritsuki.framework.common.core.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * 错误告警组件
 * 简化版本，可根据实际需求扩展
 *
 * @author ritsuki
 */
@Slf4j
public class ErrorAlarmComponent {

    /**
     * 异常告警
     *
     * @param e 异常对象
     */
    public void exceptionAlarm(Exception e) {
        // 这里可以接入实际的告警系统，如钉钉、企业微信、邮件等
        log.error("[alarm][异常告警]", e);
    }

}

