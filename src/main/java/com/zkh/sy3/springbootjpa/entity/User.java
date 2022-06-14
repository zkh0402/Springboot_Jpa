package com.zkh.sy3.springbootjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zkh
 * @date 2022/6/12 -9:30
 */
@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userPasswordAgain;

    private String userPhoto;

    private String userGender;

    private String userHobby;

    private String userDescribe;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "lId")
    private Location userLocation;  //一的实体
}

//多