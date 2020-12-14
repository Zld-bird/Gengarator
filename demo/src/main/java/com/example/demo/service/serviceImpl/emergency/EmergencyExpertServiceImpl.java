package com.example.demo.service.serviceImpl.emergency;

import cn.hutool.core.lang.Dict;
import com.example.demo.entity.emergency.EmergencyExpert;
import com.example.demo.mapper.emergency.EmergencyExpertRepository;
import com.example.demo.service.emergency.EmergencyExpertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 应急专家管理
 * @author zld
 * date: 2020/10/9
 * version: 02.06
 */
@Service
@Slf4j
public class EmergencyExpertServiceImpl implements EmergencyExpertService {
    private final EmergencyExpertRepository emergencyExpertRepository;

    public EmergencyExpertServiceImpl(EmergencyExpertRepository emergencyExpertRepository) {
        this.emergencyExpertRepository = emergencyExpertRepository;
    }

    /**
     * 分页查询
     * @param expertName
     * @param pageable
     * @return
     */
    @Override
    public Map<String, Object> queryAllPage(String expertName, Pageable pageable) {
        Page<EmergencyExpert> emergencyExperts = emergencyExpertRepository.queryAllByPage(expertName, pageable);
        return Dict.create().set("content",emergencyExperts.getContent()).set("total",emergencyExperts.getTotalElements());
    }

    /**
     * 查询唯一
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> queryOne(Long id) {
        Map<String,Object> map=new HashMap<>();
        map.put("content",emergencyExpertRepository.findById(id).orElse(new EmergencyExpert()));
        return map;
    }

    /**
     * 报存
     * @param emergencyExpert
     */
    @Override
    public void save(EmergencyExpert emergencyExpert) {
        emergencyExpert.setCreateTime(new Date());
        emergencyExpert.setIsDel((byte)1);
        emergencyExpertRepository.save(emergencyExpert);
    }

    /**
     * 修改信息
     * @param emergencyExpert
     */
    @Override
    public void update(EmergencyExpert emergencyExpert) {
        emergencyExpert.setUpdateTime(new Date());
        emergencyExpertRepository.update(emergencyExpert);
    }

    /**
     * 逻辑删除
     * @param id
     */
    @Override
    public void delete(Long id) {
        emergencyExpertRepository.updateOneById(id);
    }
}
