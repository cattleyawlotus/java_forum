package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Image;
import com.example.demo.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author : hongbo
 * @create 2021-11-23-13:00
 **/


@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    IImageService imageService;


    @PostMapping("/upload")
    public Result<?> upload(MultipartFile file) throws IOException {
        String url = imageService.saveImage(file);
        return Result.success(url);  // 返回结果 url
    }


    @PostMapping
    public Result<?> save(@RequestBody Image image){
        if(imageService.save(image)){
            return Result.success();
        }else{
            return Result.error("-1","插入失败");
        }
    }

    @PutMapping
    public Result<?> update(@RequestBody Image image){
        if(imageService.updateById(image)) {
            return Result.success();
        }else{
            return Result.error("-1","更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        if(imageService.removeById(id)) {
            return Result.success();
        }else{
            return Result.error("-1","删除失败");
        }
    }

    //找到一个
    @GetMapping("/{id}")
    public Result<?> getOne(@PathVariable Long id){
        Image res = imageService.getById(id);
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
        LambdaQueryWrapper<Image> wrapper = Wrappers.<Image>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Image::getIdUser, search);
        }
        Page<Image> answerPage = imageService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(answerPage);
    }

}
