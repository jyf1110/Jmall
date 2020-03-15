package com.taiji.jmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.taiji.jmall.bean.PmsProductInfo;
import com.taiji.jmall.manage.util.PmsUploadUtil;
import com.taiji.jmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;

    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfoList=spuService.spuList(catalog3Id);
        return pmsProductInfoList;
    }
    //图片上传到服务器
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        String imgUrl= PmsUploadUtil.UploadImage(multipartFile);
        System.out.println(imgUrl);
        return imgUrl;
    }

    //保存商品信息
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }
}
