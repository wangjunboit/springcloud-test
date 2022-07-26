package com.cloud.wjb.controller;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author xuye0422
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "响应信息主体")
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Integer SUCCESS = 0;

    public static final Integer FAIL = -1;

    @ApiModelProperty(value = "返回标记：成功标记=0，失败标记=1")
    private int code;

    @ApiModelProperty(value = "返回信息")
    private String msg;

    @ApiModelProperty(value = "请求api")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String requestUri;


    @ApiModelProperty(value = "数据")
    private T data;

    public static <T> R<T> ok() {
        return restResult(null, R.SUCCESS, "成功");
    }



    public static <T> R<T> ok(T data) {
        return restResult(data, R.SUCCESS, "成功");
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, R.SUCCESS, msg);
    }


    public static <T> R<T> failed(T data) {
        return restResult(data, R.FAIL, null);
    }

    public static <T> R<T> failed(T data, String msg) {
        return restResult(data, R.FAIL, msg);
    }

    /**
     * 未登录返回结果
     */
    public static <T> R<T> unauthorized(T data) {
        return restResult(data, 500, "500");
    }

    /**
     * 未授权返回结果
     */
    public static <T> R<T> forbidden(T data) {
        return restResult(data, 500, "500");
    }

    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
