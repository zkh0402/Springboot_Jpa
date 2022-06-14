package com.zkh.sy3.springbootjpa.service;

import com.zkh.sy3.springbootjpa.entity.User;
import com.zkh.sy3.springbootjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zkh
 * @date 2022/6/13 -10:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;



    @Override
    public String findAllUserByPage(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model) {
        //第一次访问findAllUserByPage方法时
        if (page == null){
            page = 1;
        }
        //每页显示三条记录
        int size= 3;
        Page<User> pageData = userRepository.findAll(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC,"userId")));
        //获取当前页面数据并转换成List<User>，转发到视图页面显示
        List<User> allUser = pageData.getContent();
        model.addAttribute("allUser",allUser);
        //共有多少条记录
        model.addAttribute("totalCount",pageData.getTotalElements());
        //共多少页
        model.addAttribute("totalPage",pageData.getTotalPages());
        //当前页
        model.addAttribute("page",page);
        return "main";

    }
}
