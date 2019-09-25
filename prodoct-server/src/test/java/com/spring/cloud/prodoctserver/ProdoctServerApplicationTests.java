package com.spring.cloud.prodoctserver;

import com.spring.cloud.prodoctserver.controller.mqTestController;
import com.spring.cloud.prodoctserver.entry.Product;
import com.spring.cloud.prodoctserver.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdoctServerApplicationTests {

    @Autowired
    private mqTestController mqTestController;

    @Test
    public void contextLoads() {
        mqTestController.sendMq();
    }

    @Autowired
    private ProductService productService;
    @Test
    public void elastic() {
        Product product = new Product();
        product.setId("4");
        product.setName("神雕侠侣");
        product.setCode("004");
        productService.index(product);
    }

    @Test
    public void elasticFindAll() {
        Iterable<Product> all = productService.findAll();
        all.forEach(item -> {
            System.out.println(item);
        });
    }
}
