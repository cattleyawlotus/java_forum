package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author : hongbo
 * @create 2021-11-23-13:10
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名获得相应用户对象
     * @param username
     * @return User
     */
    @Select("SELECT id,username,password,introduction,created_date FROM user WHERE username = #{username}")
    User getUserByUsername(@Param("username")String username);
}
