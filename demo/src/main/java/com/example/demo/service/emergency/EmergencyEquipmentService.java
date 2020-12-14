package com.example.demo.service.emergency;

import com.example.demo.entity.emergency.EmergencyEquipment;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface EmergencyEquipmentService {
    /**
     * 分页查询
     * @param equipmentName
     * @param pageable
     * @return
     */
    Map<String,Object> queryAllPage(String equipmentName, Pageable pageable);

    /**
     * 根据装备id查询唯一
     * @param id
     * @return
     */
    Map<String,Object> queryOne(Long id);

    /**
     * 保存装备信息
     * @param emergencyEquipment
     */
    void save(EmergencyEquipment emergencyEquipment);

    /**
     * 修改装备信息
     * @param emergencyEquipment
     */
    void update(EmergencyEquipment emergencyEquipment);

    /**
     * 逻辑删除
     * @param id
     */
    void delete(Long id);
}
