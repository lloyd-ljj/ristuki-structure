package com.ritsuki.framework.common.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * 属性：公共通用
 *
 * @author ritsuki
 */
@RefreshScope
@ConfigurationProperties(prefix = "framework.common")
@Validated
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonProperties {

    /**
     * 是否开启异常告警
     */
    @Builder.Default
    private Boolean enableAlarm = false;

    /**
     * 需要告警的错误码
     */
    private List<Long> alarmErrorCode;

}

