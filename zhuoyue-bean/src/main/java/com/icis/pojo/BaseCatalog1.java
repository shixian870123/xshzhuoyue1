package com.icis.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

// 一级分类
@Data
public class BaseCatalog1 implements Serializable{
    @Id
    @Column
    private String id;
    @Column
    private String name;
}
