package com.ritsuki.framework.common.core.enumeration;

import com.ritsuki.framework.common.core.validation.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 枚举：是否删除
 *
 * @author ritsuki
 */
@Getter
@AllArgsConstructor
public enum CommonDeletedEnum implements ArrayValuable {

    /**
     * 未删除
     */
    NOT_DELETED(0, "未删除"),
    /**
     * 已删除
     */
    DELETED(1, "已删除"),
    ;

    /**
     * 枚举值数组化
     */
    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(CommonDeletedEnum::getValue)
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
     * 获取枚举值对应的数组
     *
     * @return 枚举值对应的数组
     */
    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}

