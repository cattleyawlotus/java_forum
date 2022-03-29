package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author : hongbo
 * @create 2021-12-16-19:08
 **/

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
