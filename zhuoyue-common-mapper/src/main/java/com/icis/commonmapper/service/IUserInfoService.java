package com.icis.commonmapper.service;

import com.icis.commonmapper.pojo.UserInfo;

import java.util.List;

// 用户接口
public interface IUserInfoService {
    // 查询所有用户的方法
    public List<UserInfo> findAllUser();
    // 查询用户方法   根据主键查询一个用户数据
    public UserInfo findUserByPrimaryKey(UserInfo userInfo);
    // 根据  其它字段查询数据
    public  List<UserInfo> findUserByUserProperty(UserInfo userInfo);
    // 根据名字 模糊查询用户数据
    public  List<UserInfo> findUserByLikeName(UserInfo userInfo);
}
