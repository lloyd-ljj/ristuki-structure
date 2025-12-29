package com.ritsuki.framework.common.config;

import com.ritsuki.framework.common.core.exception.AlarmFrameworkUtil;
import com.ritsuki.framework.common.core.exception.ErrorAlarmComponent;
import com.ritsuki.framework.common.core.exception.GlobalExceptionHandler;
import com.ritsuki.framework.common.core.health.HealthCheckController;
import com.ritsuki.framework.common.core.json.JacksonConfig;
import com.ritsuki.framework.common.core.web.GlobalControllerAdvice;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 自动配置类：公共通用
 * 该配置类负责初始化框架所需的通用组件和工具类
 *
 * @author ritsuki
 */
@AutoConfiguration
@EnableConfigurationProperties(CommonProperties.class)
public class CommonAutoConfiguration {

    /**
     * 创建全局异常处理bean
     * 初始化GlobalExceptionHandler实例，用于统一处理应用程序中的异常
     *
     * @return 配置好的GlobalExceptionHandler实例
     */
    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    /**
     * 创建错误告警组件bean
     * 用于发送错误告警通知
     *
     * @return 配置好的ErrorAlarmComponent实例
     */
    @Bean
    public ErrorAlarmComponent errorAlarmComponent() {
        return new ErrorAlarmComponent();
    }

    /**
     * 创建报警框架工具bean
     * 用于初始化报警框架工具
     *
     * @param errorAlarmComponent 错误告警组件实例
     * @param commonProperties    公共属性配置
     * @return 配置好的AlarmFrameworkUtil实例
     */
    @Bean
    public AlarmFrameworkUtil alarmUtil(ErrorAlarmComponent errorAlarmComponent, CommonProperties commonProperties) {
        AlarmFrameworkUtil.init(errorAlarmComponent, commonProperties);
        return new AlarmFrameworkUtil();
    }

    /**
     * 创建健康检查控制器bean
     * 用于提供应用健康状态检查功能
     *
     * @return 配置好的HealthCheckController实例
     */
    @Bean
    public HealthCheckController healthCheckController() {
        return new HealthCheckController();
    }

    /**
     * 创建Jackson配置bean
     * 用于配置JSON序列化和反序列化相关设置
     *
     * @return 配置好的JacksonConfig实例
     */
    @Bean
    public JacksonConfig jacksonConfig() {
        return new JacksonConfig();
    }

    /**
     * 创建全局控制器建议bean
     * 用于提供全局的控制器增强功能
     *
     * @return 配置好的GlobalControllerAdvice实例
     */
    @Bean
    public GlobalControllerAdvice globalControllerAdvice() {
        return new GlobalControllerAdvice();
    }

}

