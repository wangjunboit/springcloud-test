package com.cloud.wjb.docker.controller;

import com.alibaba.fastjson.JSON;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.messages.ContainerInfo;
import com.spotify.docker.client.messages.RegistryAuth;

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
        final DockerClient docker = DefaultDockerClient.fromEnv().uri("http://10.10.71.2:2375").build();

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
        //List<Container> containers = docker.listContainers(DockerClient.ListContainersParam.allContainers());

        ContainerInfo containerInfo = docker.inspectContainer("cec6ad600e0330be833af83da450dc4b9b550501620d6c0da268c269862ac00d");
        System.out.println("123---->" + JSON.toJSONString(containerInfo));

//        HostConfig hostConfig = HostConfig.builder()
//                .nanoCpus(2*1000*1000*1000L)
//                .restartPolicy(HostConfig.RestartPolicy.unlessStopped())
//                .build();
//        ContainerUpdate containerUpdate = docker.updateContainer("cec6ad600e0330be833af83da450dc4b9b550501620d6c0da268c269862ac00d", hostConfig);
//        System.out.println(JSON.toJSONString(containerUpdate));

//        final String logs;
//        try (LogStream stream = docker.logs("nacos", DockerClient.LogsParam.stdout(), DockerClient.LogsParam.stderr())) {
//            logs = stream.readFully();
//        }
//        System.out.println(logs);
        docker.close();
    }
}
