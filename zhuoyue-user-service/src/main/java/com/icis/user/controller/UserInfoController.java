package com.icis.user.controller;

import com.icis.pojo.UserInfo;
import com.icis.user.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.util.List;

// 用户控制器
//@Controller
//@ResponseBody  // 作用域该类下面的所有的方法
@RestController
public class UserInfoController {
    @Autowired   // 从本机的spring容器中取  这个接口的实现类对象
    private IUserInfoService userInfoService;

    // 查询所有用户数据
    //@RequestMapping("getAll")
    @GetMapping("getAll")
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
    // 根据名字模糊查询数据
    @GetMapping("findByLikeName")
    public List<UserInfo> findByUserLikeName(UserInfo userInfo){
        return this.userInfoService.findUserByLikeName(userInfo);
    }


}
