package com.example.demo.service.serviceImpl;

import com.example.demo.entity.TbCoalWellboreInfo;
import com.example.demo.mapper.TbCoalWellboreInfoMapper;
import com.example.demo.service.CoalWellboreInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author admin
 * date: 2020/8/27
 * version: 02.06
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CoalWellboreInfoServiceImpl implements CoalWellboreInfoService {
    private final TbCoalWellboreInfoMapper coalWellboreInfoMapper;

    public CoalWellboreInfoServiceImpl(TbCoalWellboreInfoMapper coalWellboreInfoMapper) {
        this.coalWellboreInfoMapper = coalWellboreInfoMapper;
    }

    @Override
    public List<TbCoalWellboreInfo> findCoalWellboreList() {
        return coalWellboreInfoMapper.findWellboreList();
    }

    @Override
    public int insertWellboreInfo(TbCoalWellboreInfo coalWellboreInfo) {
        Date date = new Date();
        coalWellboreInfo.setAddTime(date);
        coalWellboreInfo.setIsDelete((byte) 1);
        return coalWellboreInfoMapper.insertWellboreInfo(coalWellboreInfo);
    }
}
