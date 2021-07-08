package com.icis.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.icis.pojo.UserAddress;
import com.icis.user.IUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 订单控制器
@Controller
public class OrderController {
    // 地址接口服务
    @Reference  // 注入本地的bean
    private IUserAddressService iUserAddressService;
    // 定义一个方法  根据用户id 获得用户地址列表
    @RequestMapping("/trade")
    @ResponseBody
    public List<UserAddress> getAddressListByUserId(String userId){
        List<UserAddress> addresseList = iUserAddressService.getUserAddressListByUserid(userId);
        return addresseList;
    }
}
