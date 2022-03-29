package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : hongbo
 * @create 2021-11-26-16:12
 **/

@TableName("book")
@Data
public class Book {
    @TableId(value ="id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private BigDecimal price;
    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    private String cover;

}
