package com.example.springboot.entity;/*
    @author GRChen
    2023/6/6 0006
*/

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                 //get,set
@NoArgsConstructor    //lombok 无参构造
@AllArgsConstructor   //lombok 有参构造
public class User {
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private String nickname;


}
