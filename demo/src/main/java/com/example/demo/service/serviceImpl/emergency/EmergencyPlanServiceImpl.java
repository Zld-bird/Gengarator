package com.example.demo.service.serviceImpl.emergency;

import cn.hutool.core.lang.Dict;
import com.example.demo.entity.emergency.EmergencyPlan;
import com.example.demo.mapper.emergency.EmergencyPlanRepository;
import com.example.demo.service.emergency.EmergencyPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 应急预案管理业务层
 * @author zld
 * date: 2020/9/29
 * version: 02.06
 */
@Slf4j
@Service
public class EmergencyPlanServiceImpl implements EmergencyPlanService {
    private final EmergencyPlanRepository emergencyPlanRepository;

    public EmergencyPlanServiceImpl(EmergencyPlanRepository emergencyPlanRepository) {
        this.emergencyPlanRepository = emergencyPlanRepository;
    }

    /**
     * 新增
     * @param emergencyPlan
     */
    @Override
    public void save(EmergencyPlan emergencyPlan) {
        emergencyPlan.setCreateTime(new Date());
        emergencyPlan.setIsDel((byte)1);
        emergencyPlanRepository.save(emergencyPlan);
    }

    /**
     * 分页查询
     * @param planName
     * @param pageable
     * @return
     */
    @Override
    public Map<String, Object> queryAllPage(String planName, Pageable pageable) {
        Page<EmergencyPlan> byPlanNameLike = emergencyPlanRepository.findAllPage(planName, pageable);
        return Dict.create().set("content",byPlanNameLike.getContent()).set("total",byPlanNameLike.getTotalElements());
    }

    /**
     * 修改
     * @param emergencyPlan
     */
    @Override
    public void update(EmergencyPlan emergencyPlan) {
        emergencyPlan.setUpdateTime(new Date());
        emergencyPlanRepository.update(emergencyPlan);
    }

    /**
     * 查询唯一
     * @param id
     * @return
     */
    @Override
    public EmergencyPlan queryOne(Long id) {
        return emergencyPlanRepository.findById(id).orElse(new EmergencyPlan());
    }

    /**
     * 逻辑删除
     * @param id
     */
    @Override
    public void delete(Long id) {
        emergencyPlanRepository.updateIsDel(id);
    }
}
