package com.taiji.jmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.taiji.jmall.bean.*;
import com.taiji.jmall.manage.mapper.PmsProductImageMapper;
import com.taiji.jmall.manage.mapper.PmsProductInfoMapper;
import com.taiji.jmall.manage.mapper.PmsProductSaleAttrMapper;
import com.taiji.jmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.taiji.jmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;
    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo=new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfoList=pmsProductInfoMapper.select(pmsProductInfo);
        return pmsProductInfoList;
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        //保存商品信息
        pmsProductInfoMapper.insertSelective(pmsProductInfo);

        //保存图片信息
        List<PmsProductImage> pmsProductImages=pmsProductInfo.getSpuImageList();
        for(PmsProductImage pmsProductImage:pmsProductImages){
            pmsProductImage.setProductId(pmsProductInfo.getId());
            pmsProductImageMapper.insertSelective(pmsProductImage);
        }
        //保存商品销售属性
        List<PmsProductSaleAttr> pmsProductSaleAttrList=pmsProductInfo.getSpuSaleAttrList();
        for(PmsProductSaleAttr pmsProductSaleAttr:pmsProductSaleAttrList){
            pmsProductSaleAttr.setProductId(pmsProductInfo.getId());
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);
            //保存商品信息属性值
            List<PmsProductSaleAttrValue>pmsProductSaleAttrValueList=pmsProductSaleAttr.getSpuSaleAttrValueList();
            for(PmsProductSaleAttrValue pmsProductSaleAttrValue:pmsProductSaleAttrValueList){
                pmsProductSaleAttrValue.setProductId(pmsProductInfo.getId());
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }
        }
    }
}
