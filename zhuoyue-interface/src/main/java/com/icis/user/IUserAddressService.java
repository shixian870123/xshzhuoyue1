package com.icis.user;

import com.icis.pojo.UserAddress;

import java.util.List;

// 用户地址服务接口
public interface IUserAddressService {
    // 根据用户id 查询用户地址列表
    public List<UserAddress> getUserAddressListByUserid(String uid);

}
