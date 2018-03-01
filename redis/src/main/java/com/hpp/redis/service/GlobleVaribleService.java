package com.hpp.redis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/3/1 10:48
 */
@Service
public class GlobleVaribleService {
    private static Logger logger = LoggerFactory.getLogger(GlobleVaribleService.class);

    @Autowired
    RestTemplate restTemplate ;
    @Autowired
    StringRedisTemplate stringRedisTemplate ;
    public void select(){
        String appid = "appid";

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(appid)) {
            logger.info("redis 存在 appid");
            String a = ops.get(appid);
        } else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            logger.info("redis 不存在appid ,已经更新" + df.format(System.currentTimeMillis()));
            ops.set("appid","aaa",7000, TimeUnit.SECONDS);
        }
    }

}
