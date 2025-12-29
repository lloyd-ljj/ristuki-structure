package com.ritsuki.server.controller;

import com.ritsuki.framework.common.core.pojo.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author ritsuki
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    /**
     * 测试接口
     *
     * @return 测试结果
     */
    @GetMapping("/hello")
    public CommonResult<String> hello() {
        return CommonResult.success("Hello, Ritsuki!");
    }

}

