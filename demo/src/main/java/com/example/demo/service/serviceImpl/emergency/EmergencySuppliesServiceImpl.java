package com.example.demo.service.serviceImpl.emergency;

import cn.hutool.core.lang.Dict;
import com.example.demo.entity.emergency.EmergencySupplies;
import com.example.demo.mapper.emergency.EmergencySuppliesRepository;
import com.example.demo.service.emergency.EmergencySuppliesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 应急物资管理
 * @author zld
 * date: 2020/10/10
 * version: 02.06
 */
@Service
@Slf4j
public class EmergencySuppliesServiceImpl implements EmergencySuppliesService {
    private final EmergencySuppliesRepository emergencySuppliesRepository;

    public EmergencySuppliesServiceImpl(EmergencySuppliesRepository emergencySuppliesRepository) {
        this.emergencySuppliesRepository = emergencySuppliesRepository;
    }

    /**
     * 分页查询
     * @param reserveName
     * @param pageable
     * @return
     */
    @Override
    public Map<String, Object> queryAllPage(String reserveName, Pageable pageable) {
        Page<EmergencySupplies> all = emergencySuppliesRepository.queryAllByPage(reserveName , pageable);
        return Dict.create().set("content",all.getContent()).set("total",all.getTotalElements());
    }

    /**
     * 查询唯一
     * @param id
     * @return
     */
    @Override
    public EmergencySupplies queryOne(Long id) {
        return emergencySuppliesRepository.findById(id).orElse(new EmergencySupplies());
    }

    /**
     * 保存
     * @param emergencySupplies
     */
    @Override
    public void save(EmergencySupplies emergencySupplies) {
        emergencySupplies.setCreateTime(new Date());
        emergencySupplies.setIsDel((byte)1);
        emergencySuppliesRepository.save(emergencySupplies);
    }

    /**
     * 修改
     * @param emergencySupplies
     */
    @Override
    public void update(EmergencySupplies emergencySupplies) {
        emergencySupplies.setUpdateTime(new Date());
        emergencySuppliesRepository.update(emergencySupplies);
    }

    /**
     * 逻辑删除
     * @param id
     */
    @Override
    public void delete(Long id) {
        emergencySuppliesRepository.updateOneById(id);
    }
}
