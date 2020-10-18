package com.prescription.memory.utils;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import org.apache.commons.lang3.SerializationException;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by Yinjie on 2020/6/5
 */
public class MyStringRedisSerializer implements RedisSerializer<Object> {
    private final Charset charset;

    public MyStringRedisSerializer(){
        this(StandardCharsets.UTF_8);
    }
    public MyStringRedisSerializer(Charset charset){
        Assert.notNull(charset,"Charset must not be null!");
        this.charset = charset;
    }
    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if (o == null){
            return new byte[0];
        }
        if (o instanceof String){
            return o.toString().getBytes(charset);
        }else{
            String string = JSON.toJSONString(o);
            return string.getBytes(charset);
        }
    }
    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return (bytes == null ? null : new String(bytes, charset));
    }
}
