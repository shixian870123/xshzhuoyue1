package com.icis.user;


import com.icis.pojo.UserInfo;

import java.util.List;

// 用户接口
public interface IUserInfoService {
    // 查询所有用户的方法
     List<UserInfo> findAllUser();
    // 查询用户方法   根据主键查询一个用户数据
     UserInfo findUserByPrimaryKey(UserInfo userInfo);
    // 根据  其它字段查询数据
      List<UserInfo> findUserByUserProperty(UserInfo userInfo);
    // 根据名字 模糊查询用户数据
      List<UserInfo> findUserByLikeName(UserInfo userInfo);
}
