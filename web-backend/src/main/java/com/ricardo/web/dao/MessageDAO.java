package com.ricardo.web.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageDAO {
    void insertMessage(MessageDAO messageDAO);
    void updateMessage(MessageDAO messageDAO);
    MessageDAO findMessageById(long Id);
    void deleteMessage(long Id);

}
