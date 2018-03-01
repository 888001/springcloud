package com.hpp.redis.service;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/3/1 13:07
 */
public interface RedisService {
    public void set(String key, Object value);

    public Object get(String key);
}
