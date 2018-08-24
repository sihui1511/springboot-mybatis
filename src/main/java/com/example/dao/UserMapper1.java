package com.example.dao;

import com.example.entity.User1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author sihui.sha
 * @date 2018/8/24
 */
@Mapper
public interface UserMapper1 {

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    @Select("select * from t_user where userName = #{userName}")
    List<User1> findByUserName(@Param("userName") String userName);

    /**
     * 查询所有
     * @return
     */
    @Select("select * from t_user")
    List<User1> findAll();

    /**
     * 保存用户信息
     * @param user1
     * @return
     */
    int insert(User1 user1);
}
