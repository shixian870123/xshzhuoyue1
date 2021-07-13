package com.icis.user;

import com.icis.pojo.BaseAttrInfo;
import com.icis.pojo.BaseCatalog1;
import com.icis.pojo.BaseCatalog2;
import com.icis.pojo.BaseCatalog3;

import java.util.List;

// 后台商品服务接口
public interface IManageService {
    // 查询所有的一级分类
    public List<BaseCatalog1> findAllBaseCatalog1();
    // 根据一级分类获得二级分类
    List<BaseCatalog2> findBaseCatalog2Bycatalog1Id(String catalog1Id);
    // 根据二级分类查询三级分类
    List<BaseCatalog3> findBaseCatalog3Bycatalog2Id(String catalog2Id);
    // 根据三级id 查询 平台属性列表
    List<BaseAttrInfo> findBaseArrtiInfoBycatalog3Id(String catalog3Id);

}
