package com.hpp.servicehi.service;

import com.hpp.servicehi.model.AuthInfo;

import java.util.List;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/2/27 11:15
 */
public interface WxAuthService {
    AuthInfo selectByPrimaryKey(Integer authId);
    List<AuthInfo> selectAll();
}
