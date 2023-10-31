package com.ricardo.web.service;

import com.ricardo.web.model.Result;
import com.ricardo.web.model.param.UserRegisterRequest;

public interface UserService {
    Result registerUser(UserRegisterRequest request);
}
