package com.ritsuki.framework.common.core.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 通用类：公共删除请求类
 *
 * @author ritsuki
 */
@Data
public class DeleteReq {

    /**
     * id
     */
    @NotNull(message = "id不能为空")
    public Long id;

}

