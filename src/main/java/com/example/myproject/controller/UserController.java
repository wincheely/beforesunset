package com.example.myproject.controller;

import com.example.myproject.dto.UserDto;
import com.example.myproject.entity.User;
import com.example.myproject.repository.UserRepository;
import com.example.myproject.utils.MD5Util;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/user/addUser")
    public String addUser(@Validated @RequestBody UserDto userDto){
        //TODO 后期追加service层，将业务逻辑转移到service
        String result = "false";
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setUserId(userDto.getUserId());
        user.setPassWord(MD5Util.EncoderByMd5(userDto.getPwd()));
        userRepository.save(user);
        if(user.getId()>0){
            result = "sucess:id:"+user.getUserId();
        }
        return result;
    }

    @DeleteMapping(value = "/user/delUser")
    public String delUser(@RequestParam int id){
        userRepository.deleteById(id);
        return "success";
    }

    @GetMapping(value = "/user/getUser")
    public String getUser(@RequestParam int id){
        User user = userRepository.findById(id).orElse(null);
        return Optional.ofNullable(user).map(User::toString).orElse("no user");
    }

}
