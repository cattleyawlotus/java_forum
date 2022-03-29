package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Image;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : hongbo
 * @create 2021-11-23-13:10
 **/

@Mapper
public interface ImageMapper extends BaseMapper<Image> {
}
