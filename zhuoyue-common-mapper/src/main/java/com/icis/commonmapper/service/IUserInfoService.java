package com.icis.commonmapper.service;

import com.icis.commonmapper.pojo.UserInfo;

import java.util.List;

// 用户接口
public interface IUserInfoService {
    // 查询所有用户的方法
    public List<UserInfo> findAllUser();
}
