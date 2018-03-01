package com.hpp.redis.controller;

import com.hpp.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/3/1 13:24
 */
@RestController
public class RedisController {
   @Autowired
    RedisService redisService ;
    @Autowired
    RedisTemplate redisTemplate;
    @RequestMapping("/get")
    public void get(){
        boolean b = redisTemplate.hasKey("appida");
        if(!b){
            redisService.set("appida","88745454545");
        }
        String key = (String) redisService.get("appida");

    }

}
