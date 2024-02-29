package com.example.springboot.exception;/*
    @author GRChen
    2023/6/10 0010
*/

import lombok.Getter;

@Getter
public class ServiceException extends  RuntimeException{

    private String code;

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
    }
}
