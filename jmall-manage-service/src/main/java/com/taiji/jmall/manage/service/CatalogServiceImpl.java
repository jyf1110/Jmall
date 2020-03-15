package com.taiji.jmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.taiji.jmall.bean.PmsBaseCatalog1;
import com.taiji.jmall.bean.PmsBaseCatalog2;
import com.taiji.jmall.bean.PmsBaseCatalog3;
import com.taiji.jmall.manage.mapper.CatalogMapper1;
import com.taiji.jmall.manage.mapper.CatalogMapper2;
import com.taiji.jmall.manage.mapper.CatalogMapper3;
import com.taiji.jmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService{
    @Autowired
    CatalogMapper1 catalogMapper1;
    @Autowired
    CatalogMapper2 catalogMapper2;
    @Autowired
    CatalogMapper3 catalogMapper3;
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {

        return catalogMapper1.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2=new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        return catalogMapper2.select(pmsBaseCatalog2);

    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3=new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        return catalogMapper3.select(pmsBaseCatalog3);
    }
}
