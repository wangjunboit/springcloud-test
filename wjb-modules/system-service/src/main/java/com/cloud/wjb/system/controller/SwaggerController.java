package com.cloud.wjb.system.controller;

import com.cloud.wjb.common.entity.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author wjb
 * @create 2022/7/26
 * @since 1.0.0
 */
@Api(tags = "swagger接口管理")
@RestController
public class SwaggerController {

    @GetMapping("/test")
    @ApiOperation("测试接口")
    public R test(@RequestParam("id") Integer id) {
        return R.ok();
    }
}
