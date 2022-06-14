package com.zkh.sy3.springbootjpa.controller;

import com.zkh.sy3.springbootjpa.entity.Location;
import com.zkh.sy3.springbootjpa.entity.User;
import com.zkh.sy3.springbootjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zkh
 * @date 2022/6/12 -10:09
 */
@Controller
public class UserController  {

    @Autowired
    UserRepository userRepository;


}
