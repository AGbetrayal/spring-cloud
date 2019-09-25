package com.spring.cloud.prodoctserver.service;

import com.spring.cloud.prodoctserver.entry.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author AGbetrayal
 * @date 2019/9/25 11:10
 */
public interface ProductService extends ElasticsearchRepository<Product, String> {
}
