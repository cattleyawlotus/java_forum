package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Topic;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.ITopicService;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author : hongbo
 * @create 2021-11-23-13:00
 **/


@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    ITopicService topicService;

    @PostMapping
    public Result<?> save(@RequestBody Topic topic){
        topic.setIdUser(1);
        topic.setCreatedDate(new Date());
        if(topicService.save(topic)){
            return Result.success();
        }else{
            return Result.error("-1","插入失败");
        }
    }

    @PutMapping
    public Result<?> update(@RequestBody Topic topic){
        if(topicService.updateById(topic)) {
            return Result.success();
        }else{
            return Result.error("-1","更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        if(topicService.removeById(id)) {
            return Result.success();
        }else{
            return Result.error("-1","删除失败");
        }
    }

    //找到一个
    @GetMapping("/{id}")
    public Result<?> getOne(@PathVariable Long id){
        Topic res = topicService.getById(id);
        if(res == null){
            return Result.error("-1","id不存在");
        }
        return Result.success(res);
    }


    //分页展示全部
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize ,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Topic> wrapper = Wrappers.<Topic>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Topic::getTitle, search);
        }
        Page<Topic> topicPage = topicService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(topicPage);
    }

}
