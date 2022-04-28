package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dai
 * @create 2022-04-2022/4/6  16-28-47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult{
    private Integer code;
    private String message;
    private Object obj;

    //定义返回结果参数
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

    //返回成功
    public static CommonResult success(String message){
        return new CommonResult(200,message,null);
    }

    public static CommonResult success(String message,Object obj){
        return new CommonResult(200,message,obj);
    }

    public static CommonResult error(String message,Object obj){
        return new CommonResult(500,message,obj);
    }

    public static CommonResult error(String message){
        return new CommonResult(500,message,null);
    }
}
