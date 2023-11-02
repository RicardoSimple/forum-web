package com.ricardo.web.dao;

import com.ricardo.web.dto.MessageDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageDAO {
    void insertMessage(MessageDO messageDO);
    void updateMessage(MessageDO messageDO);
    MessageDO findMessageById(long Id);
    void deleteMessage(long Id);

    List<MessageDO> findMessageByUserIdAndType(MessageDO messageDO);

}
