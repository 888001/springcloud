package com.hpp.servicehi.dao;

import com.hpp.servicehi.model.AuthInfo;

import java.util.List;

public interface AuthInfoMapper {
    int deleteByPrimaryKey(Integer authId);

    int insert(AuthInfo record);

    int insertSelective(AuthInfo record);

    AuthInfo selectByPrimaryKey(Integer authId);

    int updateByPrimaryKeySelective(AuthInfo record);

    int updateByPrimaryKey(AuthInfo record);
    List<AuthInfo> selectAll();
}