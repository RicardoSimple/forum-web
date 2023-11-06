package com.ricardo.web.service;

import com.ricardo.web.model.Result;
import com.ricardo.web.model.param.MessageAddParam;

public interface CommentService {
    Result addOrUpdateComment(MessageAddParam param);
}
