package com.ricardo.web.service.impl;

import com.ricardo.web.dao.CommentDAO;
import com.ricardo.web.dto.CommentDO;
import com.ricardo.web.model.Result;
import com.ricardo.web.model.param.MessageAddParam;
import com.ricardo.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;
    @Override
    public Result addOrUpdateComment(MessageAddParam param) {
        CommentDO commentDO = new CommentDO();
        commentDO.setName(param.getName());
        commentDO.setContent(param.getContent());
        commentDO.setTitle(param.getTitle());
        commentDO.setUserType(param.getUserType());

        if (param.getId().isBlank()) {
            commentDAO.insertMessage(commentDO);
        }else {
            commentDO.setId(Long.parseLong(param.getId()));
            commentDAO.updateMessage(commentDO);
        }
        return Result.success(null);
    }
}
