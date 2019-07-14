package com.spring.cloud.prodoctserver.service.impl;

import com.spring.cloud.prodoctapi.domain.Prodoct;
import com.spring.cloud.prodoctserver.mapper.ProductMapper;
import com.spring.cloud.prodoctserver.service.IProdoctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AGbetrayal
 * @date 2019/6/21 22:35
 */
@Service
public class ProdoctServiceImpl implements IProdoctService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Prodoct> list() {
        return productMapper.list();
    }
}
