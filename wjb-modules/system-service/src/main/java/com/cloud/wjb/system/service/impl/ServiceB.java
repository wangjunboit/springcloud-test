package com.cloud.wjb.system.service.impl;

import com.cloud.wjb.system.service.ServiceInterface;

public class ServiceB implements ServiceInterface {

    @Override
    public void test() {
        System.out.println("ServiceB");
    }
}