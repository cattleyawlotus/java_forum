package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Image;
import com.example.demo.entity.User;
import com.qiniu.common.Zone;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author : hongbo
 * @create 2021-12-16-19:07
 **/
public interface IImageService extends IService<Image> {
    public String getUpToken();
    public String saveImage(MultipartFile file) throws IOException;
}
