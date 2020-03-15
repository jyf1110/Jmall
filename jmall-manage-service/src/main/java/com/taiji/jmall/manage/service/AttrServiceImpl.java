package com.taiji.jmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.taiji.jmall.bean.PmsBaseAttrInfo;
import com.taiji.jmall.bean.PmsBaseAttrValue;
import com.taiji.jmall.bean.PmsBaseSaleAttr;
import com.taiji.jmall.bean.PmsProductSaleAttr;
import com.taiji.jmall.manage.mapper.AttrMapper;
import com.taiji.jmall.manage.mapper.AttrValueMapper;
import com.taiji.jmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.taiji.jmall.manage.mapper.PmsProductSaleAttrMapper;
import com.taiji.jmall.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    AttrMapper attrMapper;
    @Autowired
    AttrValueMapper attrValueMapper;
    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo=new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        return attrMapper.select(pmsBaseAttrInfo);
     }

    @Override
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        String id=pmsBaseAttrInfo.getId();
        if(StringUtils.isBlank(id)){
            //保存新建的属性，属性值
            //保存属性
            attrMapper.insertSelective(pmsBaseAttrInfo);
            //保存属性值
            List<PmsBaseAttrValue> pmsBaseAttrValueList=pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue:pmsBaseAttrValueList){
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                attrValueMapper.insertSelective(pmsBaseAttrValue);
            }

        }else {
            //保存修改后的属性和属性值
            //修改属性
            Example example=new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());
            attrMapper.updateByExampleSelective(pmsBaseAttrInfo,example);

            //修改属性值
            PmsBaseAttrValue pmsBaseAttrValueDel=new PmsBaseAttrValue();
            pmsBaseAttrValueDel.setAttrId(pmsBaseAttrInfo.getId());
            attrValueMapper.delete(pmsBaseAttrValueDel);
            List<PmsBaseAttrValue> pmsBaseAttrValueList=pmsBaseAttrInfo.getAttrValueList();
            for(PmsBaseAttrValue pmsBaseAttrValue:pmsBaseAttrValueList){
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                attrValueMapper.insertSelective(pmsBaseAttrValue);
            }




        }




    }
    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue=new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> pmsBaseAttrValueList=attrValueMapper.select(pmsBaseAttrValue);
        return pmsBaseAttrValueList;
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }
}
