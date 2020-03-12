package com.cah.cahdmsp.exception;

import com.cah.cahdmsp.result.CodeMsg;
import com.cah.cahdmsp.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandle {

    //捕获全局异常,处理所有不可知的异常
    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception ex) {
        if(ex instanceof GlobalException) {
            //处理自定义抛出的全局异常
            GlobalException gex = (GlobalException) ex;
            return Result.error(gex.getCm());
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
