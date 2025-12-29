package com.ritsuki.framework.common.core.exception;

import cn.hutool.core.collection.CollectionUtil;
import com.ritsuki.framework.common.config.CommonProperties;
import lombok.extern.slf4j.Slf4j;

/**
 * 告警工具类
 *
 * @author ritsuki
 */
@Slf4j
public class AlarmFrameworkUtil {

    private static ErrorAlarmComponent errorAlarmComponent;

    private static CommonProperties commonProperties;

    /**
     * 初始化告警工具
     * 配置静态属性，以便在静态方法中访问依赖组件
     *
     * @param errorAlarmComponent 错误告警组件实例
     * @param commonProperties    公共配置属性
     */
    public static void init(ErrorAlarmComponent errorAlarmComponent, CommonProperties commonProperties) {
        AlarmFrameworkUtil.errorAlarmComponent = errorAlarmComponent;
        AlarmFrameworkUtil.commonProperties = commonProperties;
        log.info("[init][初始化 AlarmUtil 成功]");
    }

    /**
     * 发送异常告警
     * 根据配置决定是否发送异常告警通知，支持按异常类型和错误码过滤
     *
     * @param e 待处理的异常对象
     */
    public static void alarm(Exception e) {
        if (commonProperties != null && commonProperties.getEnableAlarm() && e instanceof BusinessException be && CollectionUtil.contains(
                commonProperties.getAlarmErrorCode(), be.getCode())) {
            if (errorAlarmComponent != null) {
                errorAlarmComponent.exceptionAlarm(e);
            }
            return;
        }
        if (commonProperties != null && commonProperties.getEnableAlarm() && !(e instanceof BusinessException)) {
            if (errorAlarmComponent != null) {
                errorAlarmComponent.exceptionAlarm(e);
            }
        }
    }

}

