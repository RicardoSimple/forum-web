package com.ricardo.web.dto;

import com.ricardo.web.model.Message;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDO {
    private long id;
    private String name;
    private String userID;
    private String userType;
    private String title;
    private String content;
    private LocalDateTime gmtCreated;
    private LocalDateTime gmtModified;

    public Message toMessage(){
        Message message=new Message();
        message.setId(this.id);
        message.setName(this.name);
        message.setUserID(this.userID);
        message.setUserType(this.userType);
        message.setTitle(this.title);
        message.setContent(this.content);
        message.setGmtCreated(this.gmtCreated);
        return message;
    }

}
