package com.ricardo.web.service;

import com.ricardo.web.model.Result;
import com.ricardo.web.model.param.MessageAddParam;

public interface CommentService {
    Result addOrUpdateComment(MessageAddParam param);

    Result GetCommentById(String id);

    Result GetCommentByIdandType(String userType, Long id);
    Result GetAllCommentByType(String type,Long id);

}
