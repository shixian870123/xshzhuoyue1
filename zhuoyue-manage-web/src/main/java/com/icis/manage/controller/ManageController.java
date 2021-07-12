package com.icis.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.icis.pojo.BaseCatalog1;
import com.icis.pojo.BaseCatalog2;
import com.icis.user.IManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// 后台管理的控制器
@Controller
@CrossOrigin
public class ManageController {
    // 引用服务 接口
    @Reference
    private IManageService iManageService;
    // 查询一级分类列表  返回json数据
    @RequestMapping("/getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getBaseCatalog1(){
        return this.iManageService.findAllBaseCatalog1();
    }

    // 根据一级分类 获得二级分类  /getCatalog2?catalog1Id=1
    @RequestMapping("/getCatalog2")
    @ResponseBody
    public List<BaseCatalog2> getBaseCatalog1(String catalog1Id){
        return this.iManageService.findBaseCatalog2Bycatalog1Id(catalog1Id);
    }


}
