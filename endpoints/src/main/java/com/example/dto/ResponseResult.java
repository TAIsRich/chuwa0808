package com.example.dto;

import java.io.Serializable;

import com.example.enums.AppHttpCodeEnum;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseResult<T> implements Serializable{
    

    private Integer code;

    private String errorMessage;

    private T data;



    public ResponseResult(){
        this.code = AppHttpCodeEnum.SUCCESS.getCode();
    }

    public ResponseResult(Integer code, String msg){
        this.code = code;
        this.errorMessage = msg;
    }

    public ResponseResult(Integer code, T data){
        this.code = code;
        this.data = data;
    }

    public static ResponseResult okResult(){
        return okResult(null);
    }

    public static<T> ResponseResult okResult(T data){
        return new ResponseResult(AppHttpCodeEnum.SUCCESS.getCode(), data);
    }

    public static ResponseResult errorResult(int code, String msg){
        return new ResponseResult<>(code, msg);
    }

    public static ResponseResult errorResult(AppHttpCodeEnum enums){
        return new ResponseResult<>(enums.getCode(), enums.getErrorMessage());
    }

    public static ResponseResult errorResult(AppHttpCodeEnum enums, String errorMessage){
        return new ResponseResult<>(enums.getCode(), errorMessage);
    }
 }
