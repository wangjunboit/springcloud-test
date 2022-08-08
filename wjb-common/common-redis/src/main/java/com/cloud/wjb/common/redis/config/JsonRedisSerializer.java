package com.cloud.wjb.common.redis.config;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.cloud.wjb.common.entity.R;
import com.fasterxml.jackson.databind.JavaType;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.SerializationUtils;
import org.springframework.lang.Nullable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author wjb
 * @create 2022/8/8
 * @since 1.0.0
 */
public class JsonRedisSerializer<T> extends Jackson2JsonRedisSerializer<T> {
    private final JavaType javaType;

    public JsonRedisSerializer(Class<T> type) {
        super(type);
        this.javaType = this.getJavaType(type);
    }

    public JsonRedisSerializer(JavaType javaType) {
        super(javaType);
        this.javaType = javaType;
    }

    @Override
    public T deserialize(@Nullable byte[] bytes) throws SerializationException {
        if (ObjectUtil.isEmpty(bytes)) {
            return null;
        } else {
            try {
                String s = new String(bytes);
                return (T) JSONObject.parseObject(s, Object.class);
            } catch (Exception var3) {
                throw new SerializationException("Could not read JSON: " + var3.getMessage(), var3);
            }
        }
    }

//    @Override
//    public byte[] serialize(@Nullable Object t) throws SerializationException {
//        if (t == null) {
//            return SerializationUtils.EMPTY_ARRAY;
//        } else {
//            try {
//                return JSONObject.toJSONString(t).getBytes();
//            } catch (Exception var3) {
//                throw new SerializationException("Could not write JSON: " + var3.getMessage(), var3);
//            }
//        }
//    }
}
