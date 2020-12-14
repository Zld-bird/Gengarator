package com.example.demo.mapper;

import com.example.demo.entity.TbCorpPerson;

public interface TbCorpPersonMapper {
    int insert(TbCorpPerson record);

    int insertSelective(TbCorpPerson record);
}