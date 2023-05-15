package com.kunke.sanguo.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class MyGenericFastJsonRedisSerializer<T> implements RedisSerializer<T> {
    private static final ParserConfig defaultRedisConfig = new ParserConfig();

    private final Class<T> clazz;

    public MyGenericFastJsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        } else {
            try {
                return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(IOUtils.UTF8);
            } catch (Exception var3) {
                throw new SerializationException("Could not serialize: " + var3.getMessage(), var3);
            }
        }
    }

    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes != null && bytes.length != 0) {
            try {
                return JSON.parseObject(new String(bytes, IOUtils.UTF8), clazz, defaultRedisConfig);
            } catch (Exception var3) {
                throw new SerializationException("Could not deserialize: " + var3.getMessage(), var3);
            }
        } else {
            return null;
        }
    }

    static {
        defaultRedisConfig.setAutoTypeSupport(true);
        defaultRedisConfig.addAccept("com.kunke.");
    }
}
