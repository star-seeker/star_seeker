package com.imooc.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisOperator {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 返回给定key的剩余生存时间，单位秒
     */
    public long ttl(String key) {
        Long expire = stringRedisTemplate.getExpire(key);
        return expire == null ? 0 : expire;
    }

    /**
     * 设置过期时间，单位秒
     */
    public void expire(String key, long timeout) {
        stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 增加key, 步长为delta
     */
    public long incr(String key, long delta) {
        Long increment = stringRedisTemplate.opsForValue().increment(key, delta);
        return increment == null ? 0 : increment;
    }

    /**
     * 实现命令：KEYS pattern，查找所有符合给定模式 pattern的 key
     */
    public Set<String> keys(String pattern) {
        return stringRedisTemplate.keys(pattern);
    }

    /**
     * 删除一个key
     */
    public void del(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * SET key value
     */
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置key-value和超时时间（秒）
     */
    public void set(String key, String value, long timeout) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * GET key
     */
    public String get(String key) {
        return (String) stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 批量查询
     */
    public List<String> mget(List<String> keys) {
        return stringRedisTemplate.opsForValue().multiGet(keys);
    }

    /**
     * HSET key field value
     */
    public void hset(String key, String field, Object value) {
        stringRedisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * HGET key field，返回哈希表 key中给定域 field的值
     */
    public String hget(String key, String field) {
        return (String) stringRedisTemplate.opsForHash().get(key, field);
    }

    /**
     * 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     */
    public void hdel(String key, Object... fields) {
        stringRedisTemplate.opsForHash().delete(key, fields);
    }

    /**
     * 返回哈希表 key中，所有的域和值。
     */
    public Map<Object, Object> hgetall(String key) {
        return stringRedisTemplate.opsForHash().entries(key);
    }

    /**
     * 将一个值 value插入到列表 key的表头，返回插入后的表长
     */
    public long lpush(String key, String value) {
        Long len = stringRedisTemplate.opsForList().leftPush(key, value);
        return len == null ? 0 : len;
    }

    /**
     * 移除并返回列表 key的头元素。
     */
    public String lpop(String key) {
        return stringRedisTemplate.opsForList().leftPop(key);
    }

    /**
     * 将一个值 value插入到列表 key的表尾(最右边)。
     */
    public long rpush(String key, String value) {
        Long len = stringRedisTemplate.opsForList().rightPush(key, value);
        return len == null ? 0 : len;
    }

}