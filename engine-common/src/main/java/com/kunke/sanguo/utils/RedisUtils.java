package com.kunke.sanguo.utils;

import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class RedisUtils {

    /** -------------------key相关操作--------------------- */

    /**
     * 删除key
     *
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 批量删除key
     *
     * @param keys
     */
    public void delete(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 序列化key
     *
     * @param key
     * @return
     */
    public byte[] dump(String key) {
        return redisTemplate.dump(key);
    }

    /**
     * 是否存在key
     *
     * @param key
     * @return
     */
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public Boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param date
     * @return
     */
    public Boolean expireAt(String key, Date date) {
        return redisTemplate.expireAt(key, date);
    }

    /**
     * 查找匹配的key
     *
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * 将当前数据库的 key 移动到给定的数据库 db 当中
     *
     * @param key
     * @param dbIndex
     * @return
     */
    public Boolean move(String key, int dbIndex) {
        return redisTemplate.move(key, dbIndex);
    }

    /**
     * 移除 key 的过期时间，key 将持久保持
     *
     * @param key
     * @return
     */
    public Boolean persist(String key) {
        return redisTemplate.persist(key);
    }

    /**
     * 返回 key 的剩余的过期时间
     *
     * @param key
     * @param unit
     * @return
     */
    public Long getExpire(String key, TimeUnit unit) {
        return redisTemplate.getExpire(key, unit);
    }

    /**
     * 返回 key 的剩余的过期时间
     *
     * @param key
     * @return
     */
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }


    /**
     * 修改 key 的名称
     *
     * @param oldKey
     * @param newKey
     */
    public void rename(String oldKey, String newKey) {
        redisTemplate.rename(oldKey, newKey);
    }

    /**
     * 仅当 newkey 不存在时，将 oldKey 改名为 newkey
     *
     * @param oldKey
     * @param newKey
     * @return
     */
    public Boolean renameIfAbsent(String oldKey, String newKey) {
        return redisTemplate.renameIfAbsent(oldKey, newKey);
    }

    /**
     * 返回 key 所储存的值的类型
     *
     * @param key
     * @return
     */
    public DataType type(String key) {
        return redisTemplate.type(key);
    }

    /**
     * 设置持久化缓存对象
     */
    public void setCachePersist(String key, Object obj) {
        String value = null;
        if (obj instanceof String) {
            value = (String) obj;
        } else {
            value = JSON.toJSONString(obj);
        }
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置缓存并带过期时间
     */
    public void setCache(String key, Object obj, int timeout, TimeUnit unit) {
        String value = null;
        if (obj instanceof String) {
            value = (String) obj;
        } else {
            value = JSON.toJSONString(obj);
        }
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    /**
     * 返回String
     */
    public String getCache(String key) {
        if (!hasKey(key)) {
            return null;
        }
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取缓存并返回对象
     */
    public <T> T getCacheCls(String key, Class<T> cls) {
        String json = getCache(key);
        if (StringUtils.isBlank(json)) {
            return null;
        }
        return JSON.parseObject(json, cls);
    }

    /**
     * 获取缓存并返回对象list
     */
    public <T> List<T> getCacheList (String key, Class<T> cls) {
        String json = getCache(key);
        if (StringUtils.isBlank(json)) {
            return null;
        }
        return JSON.parseArray(json, cls);
    }

    private final StringRedisTemplate redisTemplate;
}
