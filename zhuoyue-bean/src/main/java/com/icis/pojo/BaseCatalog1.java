package com.icis.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

// 一级分类  通用mapper 默认开启驼峰命名支持  忽略大小写
@Data
public class BaseCatalog1 implements Serializable{
    @Id
    @Column
    private String id;
    @Column
    private String name;
}
