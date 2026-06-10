package com.itmy.controller;

import com.itmy.pojo.entity.Result;
import com.itmy.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
public class UploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    //上传图片
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
        log.info("上传文件:{}", file);
        if (!file.isEmpty()){
            //获取原始的文件名
            String OriginalFilename = file.getOriginalFilename();
            //上传文件到OSS并返回图片的URL
            String url = aliyunOSSOperator.upload(file.getBytes(), OriginalFilename);
            return Result.success(url);
        }
        return Result.error("上传失败");
    }
}
