package com.icis.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.icis.pojo.UserAddress;
import com.icis.user.IUserAddressService;
import com.icis.user.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service// 一个新的注解 吧服务从spring本地放入zookeeper
public class IUserAddressServiceImpl implements IUserAddressService{
    // 注入mapper
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Override
    public List<UserAddress> getUserAddressListByUserid(String uid) {
        // 创建一个用户地址对象
        UserAddress userAddress=new UserAddress();
        // 设置用户id
        userAddress.setUserId(uid);
        return this.userAddressMapper.select(userAddress);
    }
}
