package com.ymsd.exception;

import com.ymsd.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result exceptionHandler(){
        return new Result<>().error();
    }


    /**
     * 自定义异常
     */
    @ExceptionHandler(CustomException.class) //拦截CustomException.class
    @ResponseBody //以jison模式返回
    public Result custonExceptionHandler(CustomException e){
        log.error("错误原因为："+e.getMessage());
        return  new Result<>().error(e.getCode(),e.getMessage());
    }



    /**
     * 处理异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result MethodArgumentNotValidException(MethodArgumentNotValidException e){
        //获取全部字段报错提示
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        String errorText="";
        for (int i = 0; i < fieldErrors.size(); i++) {
//拿到每一项增加
            errorText+=fieldErrors.get(i).getDefaultMessage();

        }

////每次提示一条短信
//        String defaultMessage = fieldErrors.get(0).getDefaultMessage();
//        //System.out.println(e);
//        log.error("错误原因为："+defaultMessage);

        return new Result<>().error(errorText);
    }
}
