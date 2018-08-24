package com.example.dao;

import com.example.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author sihui.sha
 * @date 2018/8/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void countByUsernameTest(){
        final int count = userMapper.countByUsername("u1");
        log.info("countByUsername: {}", count);
    }

    @Test
    public void findAll(){
        final List<User> users = userMapper.selectAll();
        log.info("find all: {}",users);
    }

    @Test
    public void test() throws Exception {
        final User user1 = new User("u1", "p1");
        final User user2 = new User("u1", "p2");
        final User user3 = new User("u3", "p3");

        userMapper.insertSelective(user1);
        log.info("user1 primary key: {}", user1.getId());
        userMapper.insertSelective(user2);
        log.info("user2 primary key: {}", user2.getId());
        userMapper.insertSelective(user3);
        log.info("user3 primary key: {}", user3.getId());
        final int count = userMapper.countByUsername("u1");
        log.info("count: {}", count);

        // TODO 模拟分页
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        // TODO 分页 + 排序 this.userMapper.selectAll() 这一句就是我们需要写的查询，有了这两款插件无缝切换各种数据库
        final PageInfo<Object> pageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(() -> this.userMapper.selectAll());
        log.info("lambda pageInfo: {}", pageInfo.toString());

        PageHelper.startPage(1, 10).setOrderBy("id desc");
        final PageInfo<User> userPageInfo = new PageInfo<>(this.userMapper.selectAll());
        log.info("common pageInfo: {}", userPageInfo);
    }

}