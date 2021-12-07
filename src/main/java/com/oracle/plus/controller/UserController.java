package com.oracle.plus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oracle.plus.po.User;
import com.oracle.plus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/detail")
    public User detail(int id){
        return userService.getById(id);
    }

    @RequestMapping("/users")
    public IPage<User> users(User user,int size){
        //方式1
        Page page=new Page(1, size);
        //创建一个条件构造器
        QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
        if(user.getUsername()!=null&&!user.getUsername().equals("")) {
            userQueryWrapper.like("username", user.getUsername());
        }
        if(user.getPhone()!=null &&!user.getPhone().equals("")){
            userQueryWrapper.like("phone", user.getPhone()) ;
        }
        IPage<User> pageinfo=userService.page(page, userQueryWrapper);
        //分页相关数据    记录数据
        return pageinfo;
    }
    @RequestMapping("/delete")
    public void delete(int id){
        userService.removeById(id);
    }
}
