package com.ritsuki.framework.common.core.enumeration;

import com.ritsuki.framework.common.core.validation.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 枚举：状态
 *
 * @author ritsuki
 */
@Getter
@AllArgsConstructor
public enum CommonStatusEnum implements ArrayValuable {

    /**
     * 开启
     */
    ENABLE("0", "在用"),
    /**
     * 关闭
     */
    DISABLE("1", "停用"),
    ;

    /**
     * 枚举值数组化
     */
    public static final String[] ARRAYS = Arrays.stream(values())
            .map(CommonStatusEnum::getValue)
            .toArray(String[]::new);

    /**
     * 值
     */
    private final String value;
    /**
     * 名
     */
    private final String name;

    /**
     * 获取枚举名
     *
     * @param value 枚举值
     * @return 枚举名
     */
    public static String getName(String value) {
        for (CommonStatusEnum item : values()) {
            if (item.getValue()
                    .equals(value)) {
                return item.getName();
            }
        }
        return null;
    }

    /**
     * 获取枚举值对应的数组
     *
     * @return 枚举值对应的数组
     */
    @Override
    public String[] array() {
        return ARRAYS;
    }

}

