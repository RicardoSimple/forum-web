package com.ricardo.web.service.impl;

import com.ricardo.web.dao.CommentDAO;
import com.ricardo.web.dto.CommentDO;
import com.ricardo.web.dto.TalentUserDO;
import com.ricardo.web.dto.TeamUserDO;
import com.ricardo.web.model.Result;
import com.ricardo.web.model.TalentUser;
import com.ricardo.web.model.param.MessageAddParam;
import com.ricardo.web.service.CommentService;
import com.ricardo.web.util.Code;
import com.ricardo.web.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


    @Override
    public Result GetCommentById(String Id) {
        Long id = Long.valueOf(Id);
        if (id < 0) {
            return Result.fail(Code.FAIL_NO_ZERO, "id小于0");
        }
        List<CommentDO> commentDOs = (List<CommentDO>) CommentDAO.findMessageById(id);
        List<Long> results = new ArrayList<>();
        for (int i = 0; i < commentDOs.size(); i++) {
            results.add(commentDOs.get(i).getId());
        }
        return Result.success(results);
    }

    @Override
    public Result GetCommentByIdandType(String type, Long id) {
        if(type.equals(Const.TALENT_TYPE)){
            CommentDO GetCommentById = CommentDAO.findMessageById(id);
            if (GetCommentById == null) {
                return Result.fail(Code.FAIL_NO_DATA, "id错误");
            }
            return Result.success(GetCommentById);
        }
        CommentDO CommentById = CommentDAO.findMessageById(id);
        if(CommentById==null){
            return Result.fail(Code.FAIL_NO_DATA,"id错误");
        }
        return Result.success(CommentById);
    }



    @Override
    public Result GetAllCommentByType(String type,Long id) {
        if(type.equals(Const.TALENT_TYPE)){
            CommentDO CommentById = CommentDAO.findMessageById(id);
            if(CommentById==null){
                return Result.fail(Code.FAIL_NO_DATA,"id错误");
            }
            return Result.success(CommentById);
        }
        CommentDO CommentById = CommentDAO.findMessageById(id);
        if(CommentById==null){
            return Result.fail(Code.FAIL_NO_DATA,"id错误");
        }
        return Result.success(CommentById);
    }
}
