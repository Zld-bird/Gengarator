package com.example.demo.service.serviceImpl.emergency;

import cn.hutool.core.lang.Dict;
import com.example.demo.entity.emergency.EmergencyEquipment;
import com.example.demo.mapper.emergency.EmergencyEquipmentRepository;
import com.example.demo.service.emergency.EmergencyEquipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 应急装备管理业务层
 * @author zld
 * date: 2020/10/9
 * version: 02.06
 */
@Slf4j
@Service
public class EmergencyEquipmentServiceImpl implements EmergencyEquipmentService {
    private final EmergencyEquipmentRepository emergencyEquipmentRepository;

    public EmergencyEquipmentServiceImpl(EmergencyEquipmentRepository emergencyEquipmentRepository) {
        this.emergencyEquipmentRepository = emergencyEquipmentRepository;
    }

    /**
     * 分页查询
     * @param equipmentName
     * @param pageable
     * @return
     */
    @Override
    public Map<String, Object> queryAllPage(String equipmentName, Pageable pageable) {
        Page<EmergencyEquipment> emergencyEquipmentPage = emergencyEquipmentRepository.queryAll(equipmentName,pageable);
        return Dict.create().set("content",emergencyEquipmentPage.getContent())
                .set("total",emergencyEquipmentPage.getTotalElements());
    }

    /**
     * 查询唯一
     * @param id
     * @return
     */
    @Override
    public Map<String,Object> queryOne(Long id) {
        Map<String,Object> map = new HashMap<>();
        map.put("content",emergencyEquipmentRepository.findById(id).orElse(new EmergencyEquipment()));
        return map;
    }

    /**
     * 新增
     * @param emergencyEquipment
     */
    @Override
    public void save(EmergencyEquipment emergencyEquipment) {
        emergencyEquipment.setCreateTime(new Date());
        emergencyEquipment.setIsDel((byte)1);
        emergencyEquipmentRepository.save(emergencyEquipment);
    }

    /**
     * 修改装备信息
     * @param emergencyEquipment
     */
    @Override
    public void update(EmergencyEquipment emergencyEquipment) {
        emergencyEquipment.setUpdateTime(new Date());
        emergencyEquipmentRepository.update(emergencyEquipment);
    }

    /**
     * 逻辑删除
     * @param id
     */
    @Override
    public void delete(Long id) {
        emergencyEquipmentRepository.updateOneById(id);
    }
}
