package com.hpp.servicefeign.web;

import com.hpp.servicefeign.ServiceFeignApplication;
import org.springframework.stereotype.Component;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/2/26 16:59
 */
@Component
public class SchedualServiceHiHystric implements ServiceFeignApplication.SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
