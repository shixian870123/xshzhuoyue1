package com.icis.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.icis.manage.mapper.*;
import com.icis.pojo.*;
import com.icis.user.IManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;

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
    // 做事务的控制
    @Override
    @Transactional
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        if(baseAttrInfo.getId()!=null && baseAttrInfo.getId().length()>0){
            // 执行修改操作
            this.baseAttrInfoMapper.updateByPrimaryKey(baseAttrInfo);
        }else {
            // 1. 保存平台属性  表 base_attr_info
            this.baseAttrInfoMapper.insertSelective(baseAttrInfo);
        }


        //2. 保存平台属性值  表 base_attr_value
        // 模拟一个异常
        // 删除原有的数据  删除这个平台属性 之前的平台属性值
        BaseAttrValue deleteBaseAttriValue=new BaseAttrValue();
        // 指定条件
        deleteBaseAttriValue.setAttrId(baseAttrInfo.getId());
        this.baseAttrValueMapper.delete(deleteBaseAttriValue);


        //int i=1/0;
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        // 判断集合数据
        if(attrValueList!=null && attrValueList.size()>0){
            //添加数据
            for (BaseAttrValue baseAttrValue : attrValueList) {
                // 添加数据
                // 给平台属性值赋值
                baseAttrValue.setAttrId(baseAttrInfo.getId());
                this.baseAttrValueMapper.insertSelective(baseAttrValue);
            }

        }

    }

    @Override
    public List<BaseAttrValue> getAttrValueList(String attrId) {
        BaseAttrValue baseAttrValue=new BaseAttrValue();
        baseAttrValue.setAttrId(attrId);
        return this.baseAttrValueMapper.select(baseAttrValue);
    }
}
