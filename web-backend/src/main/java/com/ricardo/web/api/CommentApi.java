package com.ricardo.web.api;

import com.ricardo.web.model.Result;
import com.ricardo.web.model.param.MessageAddParam;
import com.ricardo.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentApi {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public Result addOrUpdateMessage(@RequestBody MessageAddParam param){
        return commentService.addOrUpdateComment(param);
    }

}
