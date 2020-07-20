package com.gds.wiki.es;

import com.gds.wiki.es.service.EsTestService;
import com.gds.wiki.es.service.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EsApplicationTests {

    @Autowired
    EsTestService esTestService;

    @Test
    void add() {
        User user=new User();
        user.setId(1L);
        user.setAddress("asddasd");
        user.setLike("zxcascas");
        user.setAge(22);
        user.setName("test1");
        esTestService.add(user);
    }

    @Test
    void addList() {
        List list=new ArrayList<>();
        for(int i=0;i<10000;i++){
            User user=new User();
            user.setId(Long.valueOf(i));
            user.setAddress("地址"+i);
            user.setLike("爱好"+i);
            user.setAge(i);
            user.setName("test"+i);
            list.add(user);
        }
        esTestService.add(list);
    }

}
