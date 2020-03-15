package com.taiji.jmall.service;

import com.taiji.jmall.bean.PmsBaseAttrInfo;
import com.taiji.jmall.bean.PmsBaseAttrValue;
import com.taiji.jmall.bean.PmsBaseSaleAttr;
import com.taiji.jmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
