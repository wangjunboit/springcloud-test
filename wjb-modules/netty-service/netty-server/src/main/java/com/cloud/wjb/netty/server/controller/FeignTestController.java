package com.cloud.wjb.netty.server.controller;

import com.cloud.wjb.common.entity.R;
import com.cloud.wjb.feign.SystermFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author wjb
 * @create 2022/7/29
 * @since 1.0.0
 */
@RestController
@RequestMapping("/feign")
public class FeignTestController {
    @Resource
    private SystermFeign systermFeign;

    @GetMapping("/test")
    @ApiOperation("测试接口")
    public R test(@RequestParam("id") Integer id) {
        return systermFeign.test(id);
    }
}
