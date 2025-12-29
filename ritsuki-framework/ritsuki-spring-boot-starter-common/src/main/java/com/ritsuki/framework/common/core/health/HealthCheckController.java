package com.ritsuki.framework.common.core.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器：健康检查
 *
 * @author ritsuki
 */
@RestController
public class HealthCheckController {

    /**
     * 健康检查
     *
     * @return 结果
     */
    @GetMapping("/checkHealth")
    public String checkHealth() {
        return "success";
    }

}

