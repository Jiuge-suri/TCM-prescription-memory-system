package com.prescription.memory.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Yinjie on 2020/5/10
 */
@Data
@ApiModel(value = "通用返回类型")
public class CommonreturnType<T> {
    //表明请求的返回处理结果“success”或“fail”
    @ApiModelProperty(value = "状态码")
    private Integer status;
    @ApiModelProperty(value = "状态信息")
    private String message;
    //若status为success，返回前端需要的json数据
    //若status为fail，返回data内使用通用的错误格式码
    @ApiModelProperty(value = "返回数据")
    private T data;

    //定义一个通用的创建方法,status默认为success
    public static CommonreturnType create(Object result){
        return CommonreturnType.create(result,"成功",1);
    }
    public static CommonreturnType create(Object result, String message,Integer status){
        CommonreturnType type = new CommonreturnType();
        type.setStatus(status);
        type.setMessage(message);
        type.setData(result);
        return type;
    }
}