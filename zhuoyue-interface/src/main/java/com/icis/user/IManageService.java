package com.icis.user;

import com.icis.pojo.BaseCatalog1;
import com.icis.pojo.BaseCatalog2;

import java.util.List;

// 后台商品服务接口
public interface IManageService {
    // 查询所有的一级分类
    public List<BaseCatalog1> findAllBaseCatalog1();
    // 根据一级分类获得二级分类
    List<BaseCatalog2> findBaseCatalog2Bycatalog1Id(String catalog1Id);
}
