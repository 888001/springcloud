package com.hpp.servicehi.service.impl;

import com.hpp.servicehi.dao.AuthInfoMapper;
import com.hpp.servicehi.model.AuthInfo;
import com.hpp.servicehi.service.WxAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/2/27 11:16
 */
@Service
public class WxAuthServiceImpl implements WxAuthService {
    @Autowired
    AuthInfoMapper authInfoMapper;
    @Override
    public AuthInfo selectByPrimaryKey(Integer authId) {
        return authInfoMapper.selectByPrimaryKey(authId);
    }

    @Override
    public List<AuthInfo> selectAll() {
        return authInfoMapper.selectAll();
    }
}
