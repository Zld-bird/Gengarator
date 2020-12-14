package com.example.demo.service;

import com.example.demo.entity.TbCoalWellboreInfo;

import java.util.List;

public interface CoalWellboreInfoService {
    List<TbCoalWellboreInfo> findCoalWellboreList();

    int insertWellboreInfo(TbCoalWellboreInfo coalWellboreInfo);
}
