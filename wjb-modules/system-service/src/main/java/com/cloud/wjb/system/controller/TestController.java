package com.cloud.wjb.system.controller;

import com.cloud.wjb.common.entity.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
public class TestController {
    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    @ApiOperation("测试接口")
    @Cacheable(cacheNames = "test", key = "#id")
    public R test(@RequestParam("id") String id) {
        redisTemplate.opsForValue().set("ID", id);
        return R.ok(id);
    }
}
