package com.example.exception;

import java.net.BindException;

import javax.validation.ConstraintViolationException;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.dto.ResponseResult;
import com.example.enums.AppHttpCodeEnum;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class BaseExceptionHandler {
    
    @ExceptionHandler(value = Exception.class)
    public ResponseResult handlerException(Exception e){
        log.error(e.getMessage());
        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseResult handlerMethodArgumentNotValidException(Exception e){
        log.error(e.getMessage());
        return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID1);
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResponseResult handlerBindException(Exception e){
        log.error(e.getMessage());
        return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID2);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public ResponseResult handlerConstraintViolationException(Exception e){
        log.error(e.getMessage());
        return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID3);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseResult handlerHttpMessageNotReadableException(Exception e){
        log.error(e.getMessage());
        return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID4);
    }


 


}
