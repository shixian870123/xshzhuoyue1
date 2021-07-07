package com.icis.commonmapper.controller;

import com.icis.commonmapper.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

// 用户控制器
@Controller
@ResponseBody  // 作用域该类下面的所有的方法
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;


}
