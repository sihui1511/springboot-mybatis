package com.example.dao;

import com.example.entity.User1;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author sihui.sha
 * @date 2018/8/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserMapper1Test {

    @Autowired
    private UserMapper1 userMapper1;

    @Test
    public void findByUserName() throws Exception {

    }

    @Test
    public void findAll() throws Exception {
        final List<User1> user1s = userMapper1.findAll();
        log.info("find result: {}", user1s);
    }

    @Test
    public void insert() throws Exception {
        final int row1 = userMapper1.insert(new User1("u1", "p1"));
        log.info("insert result: {}",row1);

        final int row2 = userMapper1.insert(new User1("u2", "p2"));
        log.info("insert result: {}",row2);

        final int row3 = userMapper1.insert(new User1("u3", "p3"));
        log.info("insert result: {}",row3);

        final List<User1> u1 = userMapper1.findByUserName("u1");
        log.info("find result: {}",u1);
    }

}