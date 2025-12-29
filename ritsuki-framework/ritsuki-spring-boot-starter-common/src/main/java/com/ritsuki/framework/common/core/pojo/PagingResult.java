package com.ritsuki.framework.common.core.pojo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ritsuki.framework.common.core.constant.CommonErrorCodeConst;
import lombok.Data;

import java.util.List;

/**
 * 分页返回结果
 *
 * @author ritsuki
 */
@Data
public class PagingResult<T> extends CommonResult<List<T>> {

    /**
     * 总数
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long total;

    /**
     * 当前页
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long start;

    /**
     * 每页数量
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long limit;

    protected PagingResult() {
    }

    public PagingResult(long code, String message, List<T> data, Long start, Long limit, Long total) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.start = start;
        this.limit = limit;
        this.total = total;
    }

    /**
     * 分页成功返回结果
     */
    public static <T> PagingResult<T> pagingSuccess(List<T> data, Long start, Long limit, Long total) {
        return new PagingResult<>(CommonErrorCodeConst.SUCCESS.code(), CommonErrorCodeConst.SUCCESS.message(), data,
                start, limit, total);
    }

    /**
     * 分页成功返回结果
     */
    public static <T> PagingResult<T> pagingSuccess(Page<T> page) {
        return new PagingResult<>(CommonErrorCodeConst.SUCCESS.code(), CommonErrorCodeConst.SUCCESS.message(),
                page.getRecords(), page.getCurrent() - 1, page.getSize(), page.getTotal());
    }

}

