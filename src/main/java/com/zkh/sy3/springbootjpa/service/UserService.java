package com.zkh.sy3.springbootjpa.service;

import com.zkh.sy3.springbootjpa.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author zkh
 * @date 2022/6/13 -10:57
 */
public interface UserService {

    public String findAllUserByPage(Integer page, Model model);

}
