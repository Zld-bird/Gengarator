package com.example.demo.service.emergency;

import com.example.demo.entity.emergency.EmergencySupplies;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * 应急物资管理
 */
public interface EmergencySuppliesService {
    /**
     * 分页查询
     * @param reserveName
     * @param pageable
     * @return
     */
    Map<String,Object> queryAllPage(String reserveName, Pageable pageable);

    /**
     * 查询唯一
     * @param id
     * @return
     */
    EmergencySupplies queryOne(Long id);

    /**
     * 保存
     * @param emergencySupplies
     */
    void save(EmergencySupplies emergencySupplies);

    /**
     * 修改
     * @param emergencySupplies
     */
    void update(EmergencySupplies emergencySupplies);

    /**
     * 逻辑删除
     * @param id
     */
    void delete(Long id);
}
