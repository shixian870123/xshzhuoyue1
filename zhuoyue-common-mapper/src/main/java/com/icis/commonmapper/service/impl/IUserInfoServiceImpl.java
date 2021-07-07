package com.icis.commonmapper.service.impl;

import com.icis.commonmapper.mapper.UserInfoMapper;
import com.icis.commonmapper.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserInfoServiceImpl implements IUserInfoService{
    //注入mapper
    @Autowired
    private UserInfoMapper userInfoMapper;


}
