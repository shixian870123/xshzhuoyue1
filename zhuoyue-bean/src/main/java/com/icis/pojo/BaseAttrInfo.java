package com.icis.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

// 平台属性
@Data
public class BaseAttrInfo implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 23 把新增加的平台属性 id 赋值给  id属性
    private String id;
    @Column
    private String attrName;
    @Column
    private String catalog3Id;
    // 封装 平台属性值数据  平台属性:平台属性值 1:N
    @Transient  // 标注 这个字段  式自己添加的字段  不是数据库字段 告诉通用mapper 不要做这个字段的映射处理
    private List<BaseAttrValue> attrValueList;
}
