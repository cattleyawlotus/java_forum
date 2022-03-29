package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.FileUtil;
import com.example.demo.entity.Image;
import com.example.demo.mapper.ImageMapper;
import com.example.demo.service.IImageService;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @author : hongbo
 * @create 2021-12-16-19:08
 **/

@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements IImageService {

    private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);
    // 设置好账号的ACCESS_KEY和SECRET_KEY
    String accessKey="eZZwUspOO-POHxxVH-f59cX9oJBxip55Am40kkBt";
    String secretKey = "lW_57U2TQomacQ2naW6bnbQZD984PhwnAT7d_XOk";

    // 要上传的空间
    String bucketName = "javaeeimage";

    private static String accessDomain = "http://r47obsdx5.hn-bkt.clouddn.com/";

    // 密钥配置
    Auth auth = Auth.create(accessKey, secretKey);
    // 构造一个带指定Zone对象的配置类
    Configuration cfg = new Configuration(Zone.zone2());
    // ...其他参数参考类注释
    UploadManager uploadManager = new UploadManager(cfg);


    // 简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(bucketName);
    }

    public String saveImage(MultipartFile file) throws IOException {
        try {
            int dotPos = file.getOriginalFilename().lastIndexOf(".");
            if (dotPos < 0) {
                return null;
            }
            String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();
            if (!FileUtil.isFileAllowed(fileExt)) {
                return null;
            }

            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;
            // 调用put方法上传
            Response res = uploadManager.put(file.getBytes(), fileName, getUpToken());
            // 打印返回的信息
            if (res.isOK() && res.isJson()) {
                // 返回这张存储照片的地址http://ox6xu9hb7.bkt.clouddn.com/f07ff5a8945b4d6fb1bfc4cc8910e0fb.png，json串格式为：{"msg":"http://ox6xu9hb7.bkt.clouddn.com/f07ff5a8945b4d6fb1bfc4cc8910e0fb.png","code":0}
                return accessDomain + JSONObject.parseObject(res.bodyString()).get("key");
            } else {
                logger.error("七牛异常:" + res.bodyString());
                return null;
            }
        } catch (QiniuException e) {
            // 请求失败时打印的异常的信息
            logger.error("七牛异常:" + e.getMessage());
            return null;
        }
    }
}
