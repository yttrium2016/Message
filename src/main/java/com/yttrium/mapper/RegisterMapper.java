package com.yttrium.mapper;

import com.yttrium.domain.Register;

public interface RegisterMapper {
    int deleteByPrimaryKey(Integer registerId);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(Integer registerId);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
    
    Register selectByCode(String code);
    
    int deleteByEmail(String emailAddress);
}