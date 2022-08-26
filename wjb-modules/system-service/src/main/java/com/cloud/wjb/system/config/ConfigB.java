package com.cloud.wjb.system.config;

import com.cloud.wjb.system.service.ServiceInterface;
import com.cloud.wjb.system.service.impl.ServiceB;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigB {
    @Bean
    @ConditionalOnMissingBean
    public ServiceInterface getServiceB() {
        return new ServiceB();
    }
}