package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author : hongbo
 * @create 2021-12-16-19:53
 **/
@TableName("topic")
@Data
public class Topic {
    @TableId(value ="id", type = IdType.AUTO)
    private Integer id;
    private Integer idUser;
    private String category;
    private String code;
    private String content;
    private String title;
    private Date createdDate;
}
