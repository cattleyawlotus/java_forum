package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Topic;
import com.example.demo.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hongbo
 * @create 2021-11-23-13:00
 **/


@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    IAnswerService answerService;

    @PostMapping
    public Result<?> save(@RequestBody Answer answer){
        if(answerService.save(answer)){
            return Result.success();
        }else{
            return Result.error("-1","插入失败");
        }
    }

    @PutMapping
    public Result<?> update(@RequestBody Answer answer){
        if(answerService.updateById(answer)) {
            return Result.success();
        }else{
            return Result.error("-1","更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        if(answerService.removeById(id)) {
            return Result.success();
        }else{
            return Result.error("-1","删除失败");
        }
    }

    //找到一个
    @GetMapping("/{id}")
    public Result<?> getOne(@PathVariable Long id){
        Answer res = answerService.getById(id);
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
        LambdaQueryWrapper<Answer> wrapper = Wrappers.<Answer>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Answer::getContent, search);
        }
        Page<Answer> answerPage = answerService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(answerPage);
    }

}
