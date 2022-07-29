package com.cloud.wjb.netty.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 〈一句话功能简述〉<br>
 * 〈system-service启动类〉
 *
 * @author wjb
 * @create 2022/7/26
 * @since 1.0.0
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.cloud.wjb.feign")
public class NettyServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NettyServerApplication.class, args);
    }
}
