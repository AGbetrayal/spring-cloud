package com.spring.cloud.prodoctserver.entry;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author AGbetrayal
 * @date 2019/9/25 11:09
 */
@Document(indexName = "productindex", type = "product")
@Data
public class Product {
    String id;
    String name;
    String code;
}
