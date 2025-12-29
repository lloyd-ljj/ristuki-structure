package com.ritsuki.framework.common.core.enumeration;

import com.ritsuki.framework.common.core.validation.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 枚举：是否
 *
 * @author ritsuki
 */
@Getter
@AllArgsConstructor
public enum CommonBooleanEnum implements ArrayValuable {

    /**
     * 否
     */
    FALSE(0, "否", "0"),
    /**
     * 是
     */
    TRUE(1, "是", "1"),
    ;

    /**
     * 枚举值数组化
     */
    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(CommonBooleanEnum::getValue)
            .toArray(Integer[]::new);

    /**
     * 值
     */
    private final Integer value;
    /**
     * 名
     */
    private final String name;
    /**
     * 字符串值
     */
    private final String strValue;

    /**
     * 获取枚举值对应的数组
     *
     * @return 枚举值对应的数组
     */
    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}

