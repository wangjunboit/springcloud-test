package com.cloud.wjb.agency.jdk;

import com.cloud.wjb.agency.state.SmsProxy;
import com.cloud.wjb.agency.state.SmsService;
import com.cloud.wjb.agency.state.SmsServiceImpl;

public class Main {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}