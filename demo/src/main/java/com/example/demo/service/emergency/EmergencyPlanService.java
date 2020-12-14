package com.example.demo.service.emergency;

import com.example.demo.entity.emergency.EmergencyPlan;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * 应急预案管理
 */
public interface EmergencyPlanService {
    /**
     * 新增
     * @param emergencyPlan
     */
    void save(EmergencyPlan emergencyPlan);

    /**
     * 分页查询
     * @param planName
     * @param pageable
     * @return
     */
    Map<String,Object> queryAllPage(String planName, Pageable pageable);

    /**
     * 修改
     * @param emergencyPlan
     */
    void update(EmergencyPlan emergencyPlan);

    /**
     * 查询唯一
     * @param id
     * @return
     */
    EmergencyPlan queryOne(Long id);

    /**
     * 逻辑删除
     * @param id
     */
    void delete(Long id);
}
