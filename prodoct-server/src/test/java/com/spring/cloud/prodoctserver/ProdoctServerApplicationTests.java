package com.spring.cloud.prodoctserver;

import com.spring.cloud.prodoctserver.controller.mqTestController;
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

}
