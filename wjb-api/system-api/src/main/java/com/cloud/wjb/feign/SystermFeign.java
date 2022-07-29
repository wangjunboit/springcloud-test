package com.cloud.wjb.feign;

import com.cloud.wjb.common.entity.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "system-service")
public interface SystermFeign {
    @GetMapping("/test")
    public R test(@RequestParam("id") Integer id);
}
