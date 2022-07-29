package com.cloud.wjb.agency.cglib;

import com.cloud.wjb.agency.jdk.JdkProxyFactory;
import com.cloud.wjb.agency.state.SmsService;
import com.cloud.wjb.agency.state.SmsServiceImpl;

public class Main {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
    }
}