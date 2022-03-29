package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author : hongbo
 * @create 2021-12-16-20:46
 **/

@TableName("answer")
@Data
public class Answer {
    @TableId(value ="id", type = IdType.AUTO)
    private Integer id;
    private String code;
    private String content;
    private boolean useful;//评论是否有用
    private Date createdDate;
    private Integer idTopic;//评论对应的话题的topicId
    private Integer idUser;//该话题的用户的userId
}
