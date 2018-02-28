package com.hpp.servicehi.service;

import com.hpp.servicehi.model.AuthInfo;

import java.util.List;
import java.util.Map;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/2/27 11:15
 */
public interface WxAuthService {
    AuthInfo selectAuthInfoByAppidMD5(Map map);
    AuthInfo selectAuthInfoByState(Map map);
}
