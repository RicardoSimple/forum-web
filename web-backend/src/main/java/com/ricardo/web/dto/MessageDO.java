package com.ricardo.web.dto;

import com.ricardo.web.model.Message;

import java.time.LocalDateTime;

public class MessageDO {
    private long id;
    private String name;
    private String userID;
    private String userType;
    private String title;
    private String content;
    private LocalDateTime gmtCreated;

    public Message toMessage(){
        Message message=new Message();
        message.setId(this.id);
        message.setName(this.name);
        message.setUserID(this.userID);
        message.setUserType(this.userType);
        message.setTitle(this.title);
        message.setContent(this.content);
        return message;
    }

}
