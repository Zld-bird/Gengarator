package com.example.demo.service.emergency;

import com.example.demo.entity.emergency.EmergencyExpert;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * 应急专家管理
 */
public interface EmergencyExpertService {
    /**
     * 分页查询
     * @param expertName
     * @param pageable
     * @return
     */
    Map<String,Object> queryAllPage(String expertName, Pageable pageable);

    /**
     * 查询唯一
     * @param id
     * @return
     */
    Map<String, Object> queryOne(Long id);

    /**
     * 保存
     * @param emergencyExpert
     */
    void save(EmergencyExpert emergencyExpert);

    /**
     * 修改信息
     * @param emergencyExpert
     */
    void update(EmergencyExpert emergencyExpert);

    /**
     * 逻辑删除
     * @param id
     */
    void delete(Long id);
}
