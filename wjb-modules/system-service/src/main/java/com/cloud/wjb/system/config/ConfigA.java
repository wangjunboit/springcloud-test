package com.cloud.wjb.system.config;

import com.cloud.wjb.system.service.ServiceInterface;
import com.cloud.wjb.system.service.impl.ServiceA;
import com.cloud.wjb.system.service.impl.ServiceB;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(ServiceB.class)
@Configuration
public class ConfigA {
    @Bean
    @ConditionalOnMissingBean
    public ServiceInterface getServiceA() {
        return new ServiceA();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigA.class);
        ServiceInterface bean = ctx.getBean(ServiceInterface.class);
        bean.test();
    }
}