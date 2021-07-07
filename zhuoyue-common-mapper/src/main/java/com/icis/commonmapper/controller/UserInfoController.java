package com.icis.commonmapper.controller;

import com.icis.commonmapper.pojo.UserInfo;
import com.icis.commonmapper.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// 用户控制器
@Controller
@ResponseBody  // 作用域该类下面的所有的方法
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;

    // 查询所有用户数据
    @RequestMapping("getAll")
    public List<UserInfo> findAllUser(){
        return this.userInfoService.findAllUser();
    }

    // 根据主键查询一个用户
    @RequestMapping("getByPrimaryKey")
    public UserInfo getUserByPrimaryKey(String uid){
        // 查询
        UserInfo userinfo=new UserInfo();
        userinfo.setId(uid);
        return this.userInfoService.findUserByPrimaryKey(userinfo);
    }
    // 根据给出的属性查询数据
    @RequestMapping("findByProperty")
    public List<UserInfo> getUserByProperty(UserInfo userInfo){
        return this.userInfoService.findUserByUserProperty(userInfo);
    }


}
