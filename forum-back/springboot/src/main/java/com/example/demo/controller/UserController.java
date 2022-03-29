package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * @author : hongbo
 * @create 2021-11-23-13:00
 **/


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    IUserService userService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody User user) {
        String password = user.getPassword();
        User res = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        if(res != null && user.getUsername().equals("admin") &&  passwordEncoder.matches(password, res.getPassword())){
            return Result.success(user);
        }
        else{
            return Result.error("-1","用户名或密码错误");
        }
    }

    @PostMapping("/register")
    public Result<?> register(@RequestBody User user) {
        User res = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        if (res != null) {
            return Result.error("-1", "用户名重复");
        }
        if (user.getPassword() == null) {
            user.setPassword(passwordEncoder.encode("123456"));
            user.setCreatedDate(new Date());
        }
        if(userService.save(user)){
            return Result.success();
        }
        else {
            return Result.error("-1", "新增失败");
        }
    }


    @PostMapping
    public Result<?> save(@RequestBody User user) {
        if (user.getPassword() == null) {
            user.setPassword(passwordEncoder.encode("123456"));
            user.setCreatedDate(new Date());
        }
        if (userService.save(user)) {
            return Result.success();
        } else {
            return Result.error("-1", "插入失败");
        }
    }

    @PutMapping
    public Result<?> update(@RequestBody User user) {
        if (userService.updateById(user)) {
            return Result.success();
        } else {
            return Result.error("-1", "更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        if (userService.removeById(id)) {
            return Result.success();
        } else {
            return Result.error("-1", "删除失败");
        }
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(User::getUsername, search);
        }
        Page<User> userPage = userService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(userPage);
    }

}
