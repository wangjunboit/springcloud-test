package com.cloud.wjb.docker.controller;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.command.ListImagesCmd;
import com.github.dockerjava.api.command.PushImageCmd;
import com.github.dockerjava.api.model.PullResponseItem;
import com.github.dockerjava.api.model.PushResponseItem;
import com.github.dockerjava.api.model.SearchItem;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.google.common.collect.ImmutableSet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author wjb
 * @create 2022/8/1
 * @since 1.0.0
 */
@RestController
@RequestMapping("/docker")
@Api(tags = "docker-java demo")
public class DockerController {
    private static String DOCKER_URL = "tcp://172.18.43.114:2375";
    DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
            .withDockerHost(DOCKER_URL)
            .withDockerTlsVerify(false)
            .withRegistryUrl("wjbit-docker.pkg.coding.ne")
            .withRegistryUsername("16675352196@163.com")
            .withRegistryPassword("2970485.a")
            .build();
    DockerClient dockerClient = DockerClientBuilder.getInstance(config).build();

    @PostMapping("/pull")
    @ApiOperation(value = "拉取镜像")
    public void pull() {
        dockerClient.pullImageCmd("wjbit-docker.pkg.coding.net/boot_test/docker/java-spring-app:20220801").exec(new ResultCallback<PullResponseItem>() {
            public void onStart(Closeable closeable) {
                System.out.println("onStart");
            }

            public void onNext(PullResponseItem object) {
                System.out.println("onNext");
                System.out.println(object.getStatus());
            }

            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            public void onComplete() {
                System.out.println("pull finished");
            }

            public void close() throws IOException {

            }
        });
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/push")
    @ApiOperation(value = "推送镜像")
    public void push() {
        dockerClient.pushImageCmd("wjbit-docker.pkg.coding.net/boot_test/docker/java-spring-app:20220801").exec(new ResultCallback<PushResponseItem>() {
            @Override
            public void close() throws IOException {
                System.out.println("close");
            }

            @Override
            public void onStart(Closeable closeable) {
                System.out.println("onStart");
            }

            @Override
            public void onNext(PushResponseItem pushResponseItem) {
                System.out.println("onNext");
                System.out.println(pushResponseItem.getStatus());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("push finished");
            }
        });
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/removeImage")
    @ApiOperation(value = "删除镜像")
    public void removeImage() {
        /**
         * TODO 怎么删除harbor上的镜像
         *
         * 参考接口 http://42.194.173.207:5000/api/v2.0/projects/wjb/repositories/nginx/artifacts/1.9
         */

        dockerClient.removeImageCmd("wjbit-docker.pkg.coding.net/boot_test/docker/java-spring-app:20220801");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/buildImage")
    @ApiOperation(value = "构建镜像")
    public void buildImage() {
        String imageName = "app";
        String imageTag = "v1";
        /**
         * 正式环境应该是 把 dockerfile jar包下载到本地
         */
        ImmutableSet<String> tag = ImmutableSet.of(imageName + ":" + imageTag);
        String imageId = dockerClient.buildImageCmd(new File("E:\\docker\\dockerfile"))
                .withTags(tag)
                .start()
                .awaitImageId();
        System.out.println(imageId);
    }


    public static void main(String[] args) {
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withDockerHost(DOCKER_URL)
                .withDockerTlsVerify(false)
                .withRegistryUrl("wjbit-docker.pkg.coding.ne")
                .withRegistryUsername("16675352196@163.com")
                .withRegistryPassword("2970485.a")
                .build();

        DockerClient dockerClient = DockerClientBuilder.getInstance(config).build();


        String imageName = "app";
        String imageTag = "v1";

        ImmutableSet<String> tag = ImmutableSet.of(imageName + ":" + imageTag);
        String imageId = dockerClient.buildImageCmd(new File("E:\\docker\\dockerfile"))
                .withTags(tag)
                .start()
                .awaitImageId();
        System.out.println(imageId);
    }
}
