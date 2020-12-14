package com.example.demo.mapper;


import com.example.demo.entity.TbCorpPaper;

public interface TbCorpPaperMapper {
    int insert(TbCorpPaper record);

    int insertSelective(TbCorpPaper record);
}