package com.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by LiNan on 2018-02-27.
 * Description: 一般value就夠用了，保存json
 */
@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 前缀
     */
    public static final String KEY_PREFIX_VALUE = "CRExpress:sys:user:value:";
    public static final String KEY_PREFIX_LIST = "CRExpress:sys:user:list:";

    /**
     * redis设值
     *
     * @param key
     * @param value
     * @param timeout
     */
    public void set(String key, String value, long timeout) {
        String k = KEY_PREFIX_VALUE + key;
        stringRedisTemplate.opsForValue().set(k, value, timeout, TimeUnit.SECONDS);
    }


    public void set(String key, String value) {
        String k = KEY_PREFIX_VALUE + key;
        stringRedisTemplate.opsForValue().set(k, value);
    }

    /**
     * redis取值
     *
     * @param key
     * @return
     */
    public String get(String key) {
        String k = KEY_PREFIX_VALUE + key;
        return stringRedisTemplate.opsForValue().get(k);
    }

    /**
     * 清除
     *
     * @param key
     */
    public void del(String key) {
        String k = KEY_PREFIX_VALUE + key;
        stringRedisTemplate.delete(k);
    }

    /**
     * 缓存list
     * @param k
     * @param v
     * @param time
     * @return
     */
    public void cacheList(String k, List<String> v, long time) {
        String key = KEY_PREFIX_LIST + k;
        ListOperations<String, String> listOps =  stringRedisTemplate.opsForList();
        listOps.rightPushAll(key, v);
        if (time > 0) stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 获取list缓存
     * @param k
     * @param start
     * @param end
     * @return
     */
    protected List<String> getList(String k, long start, long end) {
        ListOperations<String, String> listOps =  stringRedisTemplate.opsForList();
        return listOps.range(KEY_PREFIX_LIST + k, start, end);
    }

    /**
     * 移除list缓存
     * @param k
     * @return
     */
    protected boolean removeOneOfList(String k) {
        String key = KEY_PREFIX_LIST + k;
        ListOperations<String, String> listOps =  stringRedisTemplate.opsForList();
        listOps.rightPop(KEY_PREFIX_LIST + k);
        return true;
    }




}
