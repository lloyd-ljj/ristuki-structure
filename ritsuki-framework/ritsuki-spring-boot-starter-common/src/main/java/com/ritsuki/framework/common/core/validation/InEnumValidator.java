package com.ritsuki.framework.common.core.validation;

import cn.hutool.core.util.ObjectUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 校验实现：用于验证给定的值是否在指定的枚举值列表中
 *
 * @author ritsuki
 */
public class InEnumValidator implements ConstraintValidator<InEnum, Object> {

    private List<Object> values;

    /**
     * 初始化方法，在初始化时根据注解上的枚举常量列表构建值列表
     *
     * @param annotation 被验证的注解对象
     */
    @Override
    public void initialize(InEnum annotation) {
        ArrayValuable[] values = annotation.value()
                .getEnumConstants();
        if (values.length == 0) {
            this.values = Collections.emptyList();
        } else {
            this.values = Arrays.stream(values[0].array())
                    .collect(Collectors.toList());
        }
    }

    /**
     * 验证方法，判断给定的整数是否在值列表中。
     *
     * @param value   被验证的
     * @param context 约束验证上下文对象
     * @return 如果给定的整数在值列表中，则返回 true；否则返回 false
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // 为空时，默认不校验，即认为通过
        if (ObjectUtil.isEmpty(value)) {
            return true;
        }
        // 校验通过
        if (values.contains(value)) {
            return true;
        }
        // 校验不通过，自定义提示语句（因为，注解上的 value 是枚举类，无法获得枚举类的实际值）
        context.disableDefaultConstraintViolation();
        // 禁用默认的 message 的值，重新添加错误提示语句
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                .addConstraintViolation();
        return false;
    }

}

