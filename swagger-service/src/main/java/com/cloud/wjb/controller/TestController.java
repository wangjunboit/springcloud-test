package com.cloud.wjb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author wjb
 * @create 2022/7/22
 * @since 1.0.0
 */
@RestController
@Api(tags = "测试")
public class TestController {
    @ApiOperation("测试")
    @RequestMapping("/test")
    public R<AlertConfigPageVO> test() {
        return R.ok();
    }
}
