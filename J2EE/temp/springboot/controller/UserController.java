package com.example.springboot.controller;/*
    @author GRChen
    2023/6/6 0006
*/

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @PostMapping
    public  Integer save(@RequestBody User user){
      //新增或更新
      return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return  userMapper.deleteById(id);
    }

    @GetMapping
    public List<User> findAll(){
        List<User> all=userMapper.findAll();
        return all;
    }

    //分页查询
    //接口路径为/user/page
    //@RequestParam 接受 ?pageNum=1&pageSize=10
    //limit 第一个参数=(pageNum-1)*pageSize
    @GetMapping("/page")
    public Map<String, Object> findAll(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<User> data =userMapper.selectPage(pageNum,pageSize);
        Integer total= userMapper.selectTotal();
        Map<String, Object> res =new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
