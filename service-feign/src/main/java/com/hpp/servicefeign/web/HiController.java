package com.hpp.servicefeign.web;

import com.hpp.servicefeign.ServiceFeignApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/2/26 15:38
 */
@RestController
public class HiController {
    @Autowired
    ServiceFeignApplication.SchedualServiceHi schedualServiceHi;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
