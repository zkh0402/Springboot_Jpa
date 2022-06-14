package com.zkh.sy3.springbootjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author zkh
 * @date 2022/6/12 -9:30
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lId;

    private String lName;


}
