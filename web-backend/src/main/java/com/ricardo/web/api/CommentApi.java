package com.ricardo.web.api;

import com.ricardo.web.model.Result;
import com.ricardo.web.model.param.MessageAddParam;
import com.ricardo.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentApi {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public Result addOrUpdateMessage(@RequestBody MessageAddParam param){
        return commentService.addOrUpdateComment(param);
    }


    // todo
    public Result GetCommentById(@RequestParam("id") String id){
        return null;
    }

    // todo getCommontByUserIdAndUserType

    // todo getAll
}
