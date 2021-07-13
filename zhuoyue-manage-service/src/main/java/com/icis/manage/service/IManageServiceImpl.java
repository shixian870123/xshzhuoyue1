package com.icis.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.icis.manage.mapper.BaseAttrInfoMapper;
import com.icis.manage.mapper.BaseCatalog1Mapper;
import com.icis.manage.mapper.BaseCatalog2Mapper;
import com.icis.manage.mapper.BaseCatalog3Mapper;
import com.icis.pojo.BaseAttrInfo;
import com.icis.pojo.BaseCatalog1;
import com.icis.pojo.BaseCatalog2;
import com.icis.pojo.BaseCatalog3;
import com.icis.user.IManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

// 后台商品服务接口实现类
@Service
public class IManageServiceImpl implements IManageService{
    // 注入一级分类的mapper
    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;
    // 注入二级分类的maper
    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;

    @Autowired
    private BaseCatalog3Mapper baseCatalog3Mapper;

    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;

    @Override
    public List<BaseCatalog1> findAllBaseCatalog1() {
        return baseCatalog1Mapper.selectAll();
    }

    @Override
    public List<BaseCatalog2> findBaseCatalog2Bycatalog1Id(String catalog1Id) {

        BaseCatalog2 baseCatalog2=new BaseCatalog2();
        // 设置一级分类id
        baseCatalog2.setCatalog1Id(catalog1Id);
        return baseCatalog2Mapper.select(baseCatalog2);
    }
    // 实现查询三级分类
    @Override
    public List<BaseCatalog3> findBaseCatalog3Bycatalog2Id(String catalog2Id) {
        BaseCatalog3 baseCatalog3=new BaseCatalog3();
        // 设置二级分类id
        baseCatalog3.setCatalog2Id(catalog2Id);
        return baseCatalog3Mapper.select(baseCatalog3);
    }
    // 实现查询平台属性列表
    @Override
    public List<BaseAttrInfo> findBaseArrtiInfoBycatalog3Id(String catalog3Id) {
        BaseAttrInfo baseAttrInfo=new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(catalog3Id);
        return baseAttrInfoMapper.select(baseAttrInfo);
    }
}
