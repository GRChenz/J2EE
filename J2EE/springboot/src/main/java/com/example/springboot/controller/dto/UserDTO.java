package com.example.springboot.controller.dto;/*
    @author GRChen
    2023/6/9 0009
*/
/**
 * 接受前端登录请求的参数
 */

import lombok.Data;

/**
 * 接受前端登录请求的参数
 */
@Data
public class UserDTO {
    private String username;
    private String password;
    private String nickname;
    private String avatarurl;
    private String token;
}