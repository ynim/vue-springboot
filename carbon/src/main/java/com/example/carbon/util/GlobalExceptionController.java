package com.example.carbon.util;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {
	
    
        /**
     * 处理方法参数异常，如 实体类上的@NotBlank注解异常，@NotNull注解等异常信息返回。
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult handleMethodArgumentException(MethodArgumentNotValidException  ex){

        return new ResponseResult(-1,ex.getBindingResult().getFieldError().getDefaultMessage()) ;
    }
    
    
        /**
     * 断言、自定义异常等处理
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception  ex){

        return  new ResponseResult(-1,ex.getMessage()) ;
    }
   
}