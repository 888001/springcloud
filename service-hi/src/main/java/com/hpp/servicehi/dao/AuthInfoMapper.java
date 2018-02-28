package com.hpp.servicehi.dao;

import com.hpp.servicehi.model.AuthInfo;

import java.util.Map;

public interface AuthInfoMapper {
    int deleteByPrimaryKey(Integer authId);

    int insert(AuthInfo record);

    int insertSelective(AuthInfo record);

    AuthInfo selectByPrimaryKey(Integer authId);

    int updateByPrimaryKeySelective(AuthInfo record);

    int updateByPrimaryKey(AuthInfo record);
    AuthInfo selectAuthInfoByAppidMD5(Map map);
    AuthInfo selectAuthInfoByState(Map map);
}