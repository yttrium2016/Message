package com.yttrium.mapper;


import java.util.List;

import com.yttrium.domain.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
    
    List<Message> selectAll();
}