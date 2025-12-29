package com.ritsuki.framework.common.core.pojo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 分页参数
 *
 * @author ritsuki
 */
@Data
public class PageParam {

    /**
     * 分页起始位置
     */
    @NotNull(message = "分页起始位置不能为空")
    @Min(value = 0, message = "分页起始位置不能小于0")
    private Integer start;

    /**
     * 分页大小
     */
    @NotNull(message = "分页大小不能为空")
    @Min(value = 1, message = "分页大小不能小于1")
    @Max(value = 100, message = "分页大小不能大于100")
    private Integer limit;

}

