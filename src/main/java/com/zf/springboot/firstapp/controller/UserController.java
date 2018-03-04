package com.zf.springboot.firstapp.controller;

import com.zf.springboot.firstapp.domain.User;
import com.zf.springboot.firstapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/3/4.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param
     * @return
     */
    @PostMapping("/user/save")
    public User save(@RequestBody User user1){

        User user = new User();
        user.setName(user1.getName());
        userRepository.save(user);
        return user;
    }
}
