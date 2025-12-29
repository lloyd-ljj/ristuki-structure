package com.ritsuki.framework.common.core.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 校验注解：判断一个值是否在指定的枚举范围内
 *
 * @author ritsuki
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {InEnumValidator.class})
public @interface InEnum {

    /**
     * 枚举类
     */
    Class<? extends ArrayValuable> value();

    /**
     * 错误消息
     */
    String message() default "必须在指定范围";

    /**
     * 组
     */
    Class<?>[] groups() default {};

    /**
     * 负载
     */
    Class<? extends Payload>[] payload() default {};

}

