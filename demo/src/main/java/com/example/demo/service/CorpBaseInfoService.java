package com.example.demo.service;

import com.example.demo.entity.TbCoalAttribute;
import com.example.demo.entity.TbCorpBaseInfo;

public interface CorpBaseInfoService {
    TbCorpBaseInfo findCorpBaseInfoByCoalmineCode();

    TbCoalAttribute findCorpAttributeInfoByCoalmineCode();

}
