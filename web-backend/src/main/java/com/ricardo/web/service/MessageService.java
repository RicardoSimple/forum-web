package com.ricardo.web.service;

import com.ricardo.web.model.Result;
import com.ricardo.web.model.param.MessageAddParam;
import org.springframework.stereotype.Service;

public interface MessageService {
    Result addMessage(MessageAddParam param);
}
