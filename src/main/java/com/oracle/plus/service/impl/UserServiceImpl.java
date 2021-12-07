package com.oracle.plus.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oracle.plus.po.User;
import com.oracle.plus.mapper.UserMapper;
import com.oracle.plus.service.UserService;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
