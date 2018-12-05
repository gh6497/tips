package cn.len.spring.tips.web.controller;


import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author len
 * @date 2018年 11月18日
 */
@RestControllerAdvice
public class GlobalControllerAdvice {
    // ------------------------4xx---------------------

    @ExceptionHandler(IllegalArgumentException .class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> illegalArgumentException(IllegalArgumentException e) {
            e.printStackTrace();
        System.out.println(e.getLocalizedMessage());
        System.out.println(e.getMessage());
        final Map<String, Object> response = defaultResponse();
        return response;
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> bindException(BindException e) {
        e.printStackTrace();
        final Map<String, Object> response = defaultResponse();
        response.put("message","请求参数错误");
        final Map<String, Object> details = new HashMap<>(0);
        e.getFieldErrors().forEach(fe -> {
            details.put(fe.getField(), fe.getRejectedValue() + "：" + fe.getDefaultMessage());
        });
        response.put("details", details);
        return response;
    }

    // ---------------------5xx---------------------------

    /**
     *
     * @param e 异常
     * @return 消息
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> exception(Exception e) {
        e.printStackTrace();
        return defaultResponse();
    }

    private Map<String, Object> defaultResponse() {
        Map<String,Object> response = new HashMap<>(3);
        // 发生错误时间
        final String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        response.put("date", now);
        // 消息
        response.put("message", "内部服务器未知错误请联系管理员处理");
        return response;
    }


}
