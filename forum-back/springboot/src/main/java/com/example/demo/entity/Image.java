package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author : hongbo
 * @create 2021-12-16-21:12
 **/
@TableName("image")
@Data
public class Image {
    @TableId(value ="id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "imgUrl")
    private String imgUrl;
    private Integer idUser;

}
