package com.ricardo.web.api;


import cn.hutool.http.server.HttpServerRequest;
import com.ricardo.web.model.param.UserLoginRequest;
import com.ricardo.web.model.param.UserRegisterRequest;
import com.ricardo.web.service.UserService;
import com.ricardo.web.util.Code;
import com.ricardo.web.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ricardo.web.model.Result;

import java.net.HttpCookie;

@RestController
@RequestMapping("/api/auth")
public class LoginApi {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result registerUser(@RequestBody UserRegisterRequest param) {
        Result result = userService.registerUser(param);

        return result;
    }

    @PostMapping("/login")
    public Result login(HttpServerRequest request, @RequestBody UserLoginRequest param) {
        if(param.getPhone().isBlank()){
            return Result.fail(Code.FAIL_DUPLICATE,"手机号为空");
        }
        long loginStatus = userService.login(param.getUserType(),param.getPhone(),param.getPwd());
        if (loginStatus<0){
            return Result.fail(Code.FAIL_NO_AUTH,"密码或手机号不正确");
        }
        HttpCookie httpCookie = new HttpCookie(param.getUserType(), loginStatus + "");
        httpCookie.setMaxAge(6000);
        request.getCookieMap().put(Const.COOKIE_KEY,httpCookie);
        // 返回登录成功信息
        return Result.success(null);
    }

    @GetMapping("/logout")
    public Result logout(HttpServerRequest request) {
        request.getCookieMap().remove(Const.COOKIE_KEY);
        return Result.success(null);
    }

    @GetMapping("/user")
    public Result getCurrentUser(HttpServerRequest request) {
        HttpCookie httpCookie = request.getCookieMap().get(Const.COOKIE_KEY);
        if(httpCookie==null){
            return Result.fail(Code.FAIL_NO_AUTH,"未登录");
        }
        String userType = httpCookie.getName();
        Long id = Long.valueOf(httpCookie.getValue());
        return userService.getUserByIdAndType(userType,id);
    }
}
