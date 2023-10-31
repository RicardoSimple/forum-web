package com.ricardo.web.api;

import cn.hutool.http.server.HttpServerRequest;
import com.ricardo.web.model.param.UserRegisterRequest;
import com.ricardo.web.service.UserService;
import com.ricardo.web.util.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ricardo.web.model.Result;

@RestController
@RequestMapping("/api/login")
public class LoginApi {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result registerUser(@RequestBody UserRegisterRequest param) {
        Result result = userService.registerUser(param);

        return result;
    }

//    @PostMapping("/login")
//    public Result login(HttpServerRequest request,@RequestBody UserLoginRequest param) {
//        // 用户登录逻辑已由Spring Security处理，无需额外方法
//        // 返回登录成功信息
//    }
//
//    @GetMapping("/logout")
//    public Result logout() {
//        // 用户注销逻辑已由Spring Security处理，无需额外方法
//        // 返回注销成功信息
//    }
//
//    @GetMapping("/user")
//    public Result getCurrentUser() {
//    }
}
