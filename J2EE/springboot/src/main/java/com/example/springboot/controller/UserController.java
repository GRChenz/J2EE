package com.example.springboot.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Constants;
import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.UserDTO;
import com.example.springboot.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.springboot.service.IUserService;
import com.example.springboot.entity.User;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author GRChen
 * @since 2023-06-09
 */
@RestController
@RequestMapping("/user")
public class UserController {

            @Autowired
            private IUserService userService;

            // 新增或者更新
            @PostMapping
            public Result save(@RequestBody User user) {
                return Result.success(userService.saveOrUpdate(user)) ;
            }

            @DeleteMapping("/{id}")
            public Result delete(@PathVariable Integer id) {
                return  Result.success(userService.removeById(id)) ;
            }

            @PostMapping("/del/batch")
            public Result deleteBatch(@RequestBody List<Integer> ids) {
                return  Result.success(userService.removeByIds(ids)) ;
            }

            @GetMapping
            public Result findAll() {
                return Result.success(userService.list());
            }

            @GetMapping("/{id}")
            public Result findOne(@PathVariable Integer id) {
                return Result.success(userService.getById(id)) ;
            }

            @GetMapping("/username/{username}")
            public Result findOne(@PathVariable String username) {
                QueryWrapper<User> queryWrapper =new QueryWrapper<>();
                queryWrapper.eq("username",username);
                return Result.success(userService.getOne(queryWrapper)) ;
            }

            //分页查询
            @GetMapping("/page")
            public Result findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
                 QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                 queryWrapper.orderByDesc("id");
                 return Result.success(userService.page(new Page<>(pageNum, pageSize), queryWrapper)) ;
            }

            @PostMapping("/login")
            public Result login(@RequestBody UserDTO userDTO) {
                String username = userDTO.getUsername();
                String password = userDTO.getPassword();
                if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {return Result.error(Constants.CODE_400,"参数错误");}
                UserDTO dto =userService.login(userDTO);
                return Result.success(dto);
            }

            @PostMapping("/register")
            public Result register(@RequestBody UserDTO userDTO){
                String username = userDTO.getUsername();
                String password = userDTO.getPassword();
                if(StrUtil.isBlank(username)||StrUtil.isBlank(password)){
                    return Result.error(Constants.CODE_400,"参数错误");
                }
                return Result.success(userService.register(userDTO));
            }

}
