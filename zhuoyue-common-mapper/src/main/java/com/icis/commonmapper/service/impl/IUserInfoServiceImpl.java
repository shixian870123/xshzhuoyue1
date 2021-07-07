package com.icis.commonmapper.service.impl;

import com.icis.commonmapper.mapper.UserInfoMapper;
import com.icis.commonmapper.pojo.UserInfo;
import com.icis.commonmapper.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserInfoServiceImpl implements IUserInfoService{
    //注入mapper
    @Autowired
    private UserInfoMapper userInfoMapper;
    // 实现查询所有用户数据
    @Override
    public List<UserInfo> findAllUser() {
        // 查询所有  select * from user_info
        return userInfoMapper.selectAll();

    }

    @Override
    public UserInfo findUserByPrimaryKey(UserInfo userInfo) {
        //  select * from user_info where id=
        return this.userInfoMapper.selectByPrimaryKey(userInfo);
    }
    // 根据条件  查询  条件 封装到属性中
    @Override
    public List<UserInfo> findUserByUserProperty(UserInfo userInfo) {
        return this.userInfoMapper.select(userInfo);
    }




}
