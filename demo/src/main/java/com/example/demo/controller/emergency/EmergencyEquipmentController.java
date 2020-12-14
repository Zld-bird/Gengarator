package com.example.demo.controller.emergency;

import com.example.demo.entity.emergency.EmergencyEquipment;
import com.example.demo.service.emergency.EmergencyEquipmentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * 应急装备管理
 * @author zld
 * date: 2020/10/9
 * version: 02.06
 */
@Validated
@RestController
@RequestMapping("api/emergency/equipment")
public class EmergencyEquipmentController {
    private final EmergencyEquipmentService emergencyEquipmentService;

    public EmergencyEquipmentController(EmergencyEquipmentService emergencyEquipmentService) {
        this.emergencyEquipmentService = emergencyEquipmentService;
    }

    /**
     * 分页查询
     * @param equipmentName
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/query")
    public ResponseEntity queryAllByPage(@RequestParam(value = "equipmentName") String equipmentName,
                                         @RequestParam(value = "page") Integer page,
                                         @RequestParam(value = "size") Integer size){
        Pageable pageable = page != null && size != null ? PageRequest.of(page, size) : Pageable.unpaged();
        return new ResponseEntity<>(emergencyEquipmentService.queryAllPage(equipmentName,pageable), HttpStatus.OK);
    }

    /**
     * 查询唯一
     * @param id
     */
    @GetMapping(value = "/queryOne")
    public ResponseEntity queryOne(@RequestParam @NotNull Long id){
        return new ResponseEntity<>(emergencyEquipmentService.queryOne(id),HttpStatus.OK);
    }

    /**
     * 新增或修改
     * @param emergencyEquipment
     */
    @PostMapping(value = "/insertOrUpdate")
    public void saveOrUpdate(@RequestBody EmergencyEquipment emergencyEquipment){
        if(null == emergencyEquipment.getId()) {
            emergencyEquipmentService.save(emergencyEquipment);
        }else {
            emergencyEquipmentService.update(emergencyEquipment);
        }
    }

    /**
     * 删除
     * @param id
     */
    @GetMapping(value = "/delete")
    public void delete(@RequestParam @NotNull Long id){
        emergencyEquipmentService.delete(id);
    }


}
