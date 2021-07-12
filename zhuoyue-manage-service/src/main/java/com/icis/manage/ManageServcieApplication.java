package com.icis.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

// 商品后台的服务端启动类
@SpringBootApplication
@MapperScan("com.icis.manage.mapper")
public class ManageServcieApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageServcieApplication.class,args);
    }
}
