package com.taiji.jmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.taiji.jmall.bean.PmsBaseAttrInfo;
import com.taiji.jmall.bean.PmsBaseAttrValue;
import com.taiji.jmall.bean.PmsBaseSaleAttr;
import com.taiji.jmall.bean.PmsProductSaleAttr;
import com.taiji.jmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class AttrController {

    @Reference
    AttrService attrService;

    //基本销售属性列表
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        return attrService.baseSaleAttrList();
    }


    //属性列表
    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        return attrService.attrInfoList(catalog3Id);
    }

    //保存属性和属性值，用于修改和新增操作时
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        attrService.saveAttrInfo(pmsBaseAttrInfo);

        return "success";
    }

    //获得属性值列表
    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue> pmsBaseAttrValueList=attrService.getAttrValueList(attrId);
        return pmsBaseAttrValueList;

    }
}
