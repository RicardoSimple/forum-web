package com.ricardo.web.service.impl;

import com.ricardo.web.dao.MessageDAO;
import com.ricardo.web.dto.MessageDO;
import com.ricardo.web.model.Result;
import com.ricardo.web.model.param.MessageAddParam;
import com.ricardo.web.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO messageDAO;
    @Override
    public Result addMessage(MessageAddParam param) {
        MessageDO messageDO = new MessageDO();
        messageDO.setName(param.getName());
        messageDO.setContent(param.getContent());
        messageDO.setTitle(param.getTitle());
        messageDO.setUserType(param.getUserType());

        messageDAO.insertMessage(messageDO);
        return Result.success(null);
    }
}
