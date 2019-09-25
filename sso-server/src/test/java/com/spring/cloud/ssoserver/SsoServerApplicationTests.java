package com.spring.cloud.ssoserver;

import com.spring.cloud.ssoserver.emtry.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsoServerApplicationTests {

    /*@Autowired
    private ElasticsearchTemplate elasticsearchTemplate;*/
//    @Autowired
//    private UserElasticSearch userElasticSearch;

    @Test
    public void elase() {
        User user = new User();
        user.setId("1");
        user.setName("elasticsearch");
        user.setPassword("elasticsearch");
        user.setEmail("elasticsearch@Xx.com");
       // userElasticSearch.index(user);
//        String encode = new BCryptPasswordEncoder().encode("123456");
//        System.out.println(encode);
    }

    @Test
    public void contextLoads() {

        String encode = new BCryptPasswordEncoder().encode("123456");
        System.out.println(encode);
    }



}
