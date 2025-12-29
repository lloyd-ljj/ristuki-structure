package com.ritsuki.framework.common.core.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用类：KV键值对
 *
 * @author ritsuki
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KeyValue<K, V> implements Serializable {

    /**
     * 键
     */
    private K key;

    /**
     * 值
     */
    private V value;

}

