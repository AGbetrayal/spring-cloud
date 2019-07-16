package com.spring.cloud.ssoserver.emtry;

import lombok.Data;

import javax.persistence.*;

/**
 * @author AGbetrayal
 * @date 2019/7/15 18:00
 */
@Entity
@Table( name = "xc_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "salt")
    private String salt;
    @Column(name = "name")
    private String name;
    @Column(name = "userpic")
    private String userpic;
    @Column(name = "utype")
    private String utype;
    @Column(name = "email")
    private String email;
    @Column(name = "status")
    private String status;
}
