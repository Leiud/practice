package com.example.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Json 封装体 CommentResult，传给前端，判断编码是否成功，成功才显示
 * 返回给前端的通用 json 数据串
 * @param <T>   泛型：如果装的 payment 返回 payment,装的 order 返回 order
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    // 泛型，对应类型的json数据
    private T data;

    /**
     * 自定义两个参数的构造方法
     * @param code
     * @param message
     */
    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}

