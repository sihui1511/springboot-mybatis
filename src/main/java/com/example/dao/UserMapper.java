package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author sihui.sha
 * @date 2018/8/24
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{

    /**
     * 根据用户名统计
     * @param username
     * @return
     */
    int countByUsername(String username);
}
