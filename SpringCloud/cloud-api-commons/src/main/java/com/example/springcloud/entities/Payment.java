package com.example.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 主实体类 Payment
 * 这三个注解是 lombok 的，除了导入依赖，idea 还需要安装插件
 * @Data   set/get 方法
 * @AllArgsConstructor 有参构造器
 * @NoArgsConstructor  无参构造器
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private long id;
    private String serial;
}
