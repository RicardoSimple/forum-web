package com.ricardo.web.api;

import com.ricardo.web.model.Result;
import com.ricardo.web.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Result getAllUsers(@Param("type")String type){
     return userService.getAllUsersByType(type);
    }
}
