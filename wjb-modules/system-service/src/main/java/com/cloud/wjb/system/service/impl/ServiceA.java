package com.cloud.wjb.system.service.impl;

import com.cloud.wjb.system.service.ServiceInterface;

public class ServiceA implements ServiceInterface {

    @Override
    public void test() {
        System.out.println("ServiceA");
    }
}