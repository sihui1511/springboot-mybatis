package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sihui.sha
 * @date 2018/8/24
 */
@Data
public class User1 implements Serializable {

    private static final long serialVersionUID = -2248190721476487645L;

    private Long id;

    private String userName;

    private String password;

    public User1(){}

    public User1(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public User1(Long id, String userName, String password){
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
