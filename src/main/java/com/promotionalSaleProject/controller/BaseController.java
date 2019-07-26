package com.promotionalSaleProject.controller;

import com.promotionalSaleProject.error.BusinessException;
import com.promotionalSaleProject.error.EmBusinessError;
import com.promotionalSaleProject.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
    // 定义exceptionhandler解决未被controller层吸收的exception

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object HandlerException(HttpServletRequest request, Exception ex){
        Map<String,Object> responseData = new HashMap<>();
        if(ex instanceof BusinessException){
            BusinessException businessException = (BusinessException)ex;
            responseData.put("errorCode",businessException.getErrCode());
            responseData.put("errorMsg",businessException.getErrMsg());
        }else{
            responseData.put("errorCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errorMsg",EmBusinessError.UNKNOWN_ERROR.getErrMsg());
        }
        return CommonReturnType.create(responseData,"fail");





    }

}
