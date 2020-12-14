package com.example.demo.service.serviceImpl;

import com.example.demo.entity.TbCoalAttribute;
import com.example.demo.entity.TbCorpBaseInfo;
import com.example.demo.mapper.TbCoalAttributeMapper;
import com.example.demo.mapper.TbCorpBaseInfoMapper;
import com.example.demo.service.CorpBaseInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author admin
 * date: 2020/8/25
 * version: 02.06
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CorpBaseInfoServiceImpl implements CorpBaseInfoService {

    private final TbCorpBaseInfoMapper corpBaseInfoMapper;
    private final TbCoalAttributeMapper coalAttributeMapper;

    public CorpBaseInfoServiceImpl(TbCorpBaseInfoMapper corpBaseInfoMapper, TbCoalAttributeMapper tbCoalAttributeMapper) {
        this.corpBaseInfoMapper = corpBaseInfoMapper;
        this.coalAttributeMapper = tbCoalAttributeMapper;
    }

    /**
     * 根据煤矿编号查询企业信息
     * @return
     */
    @Override
    public TbCorpBaseInfo findCorpBaseInfoByCoalmineCode() {
        return corpBaseInfoMapper.selectDetailByCoalmineCode();
    }

    /**
     * 根据煤矿编号查询企业属性信息
     * @return
     */
    @Override
    public TbCoalAttribute findCorpAttributeInfoByCoalmineCode() {
        return coalAttributeMapper.findCorpAttributeInfoByCoalmineCode();
    }

}
