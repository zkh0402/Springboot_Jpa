package com.zkh.sy3.springbootjpa.controller;

import com.zkh.sy3.springbootjpa.entity.Location;
import com.zkh.sy3.springbootjpa.entity.User;
import com.zkh.sy3.springbootjpa.repository.LocationRepository;
import com.zkh.sy3.springbootjpa.repository.UserRepository;
import com.zkh.sy3.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author zkh
 * @date 2022/6/12 -12:23
 */
@Controller
public class IndexController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UserService userService;

    @GetMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String toRegister(Model model){
        List<Location> locationList = locationRepository.findAll();
        model.addAttribute("location",locationList);
        return "register";
    }

    @PostMapping("/register")
    public String register(User user, MultipartFile photo,HttpSession session,Model model, Integer lId) throws IOException {

        //获得选取位置的id获得位置，并且添加到user的userLocation里
        Location userLocation = locationRepository.getReferenceById(lId);
        user.setUserLocation(userLocation);
        //获得照片名字，上传到E：//file_test
        String originalFilename = photo.getOriginalFilename();
        photo.transferTo(new File("E:\\file_test\\"+originalFilename));
        user.setUserPhoto("E:\\file_test\\"+originalFilename);
        if (!user.getUserPassword().equals(user.getUserPasswordAgain())){
            session.setAttribute("msg","两次输入的密码不一样，请重新输入");
            return "redirect:/register";
        }else {
            userRepository.save(user);
            model.addAttribute("msg","注册用户成功，请登录");
            return "/login";
        }

    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        //获取所有用户名，把输入的用户名与查找到的比较
        List<String> allUserName = userRepository.findAllUserName();
        //用户名若存在
        if(allUserName.contains(user.getUserName())){
            //根据输入的用户名获取到用户
            User loginUser = userRepository.findByUserName(user.getUserName());
            //如果用户名不为空且密码与数据库的相同
            if (StringUtils.hasLength(user.getUserName())&&loginUser.getUserPassword().equals(user.getUserPassword())){
                //把登陆的用户存入session中
                session.setAttribute("loginUser",loginUser);
                return "redirect:/main";
            }
            model.addAttribute("msg","账号密码错误");
            return "login";
        }else {
            model.addAttribute("msg","用户名不存在");
            return "login";
        }

    }

    //去main.html页面
    @GetMapping("/main")
    public String mainPage(Integer page,Model model){
        //分页查询
        return userService.findAllUserByPage(page,model);
    }


}
