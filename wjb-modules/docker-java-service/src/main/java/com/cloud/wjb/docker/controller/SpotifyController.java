package com.cloud.wjb.docker.controller;

import com.alibaba.fastjson.JSONObject;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.LogStream;
import com.spotify.docker.client.ProgressHandler;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.*;

import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 〈一句话功能简述〉<br>
 * 〈spotify测试〉
 *
 * @author wjb
 * @create 2022/8/15
 * @since 1.0.0
 */
public class SpotifyController {
    public static void main(String[] args) throws Exception {
        // Create a client based on DOCKER_HOST and DOCKER_CERT_PATH env vars
        final DockerClient docker = DefaultDockerClient.fromEnv().uri("http://172.18.43.114:2375").build();

        // Pull an image
        //docker.pull("busybox:latest");

//        ContainerInfo info = docker.inspectContainer("nacos");
//        System.out.println(JSONObject.toJSONString(info.image()));

//        final AtomicReference<String> imageIdFromMessage = new AtomicReference<>();
//
//        final String returnedImageId = docker.build(
//                Paths.get("E:\\docker\\dockerfile"), "test:v1", new ProgressHandler() {
//                    @Override
//                    public void progress(ProgressMessage message) throws DockerException {
//                        final String imageId = message.buildImageId();
//                        if (imageId != null) {
//                            imageIdFromMessage.set(imageId);
//                        }
//                    }
//                });

        //docker.tag("test:v1","wjbit-docker.pkg.coding.net/boot_test/docker/test:v1");

        // By pulling
        final RegistryAuth registryAuth = RegistryAuth.builder()
                .serverAddress("http://wjbit-docker.pkg.coding.ne")
                .username("16675352196@163.com")
                .password("2970485.a")
                .build();
        // wjbit-docker.pkg.coding.net/boot_test/docker/java-spring-app:20220801
        //docker.push("wjbit-docker.pkg.coding.net/boot_test/docker/test:v1",registryAuth);


        //docker.pull("wjbit-docker.pkg.coding.net/boot_test/docker/java-spring-app:20220801",registryAuth);

        final String logs;
        try (LogStream stream = docker.logs("nacos", DockerClient.LogsParam.stdout(), DockerClient.LogsParam.stderr())) {
            logs = stream.readFully();
        }
        System.out.println(logs);
        docker.close();
    }
}
