package com.example.demo.controller.emergency;

import com.example.demo.entity.emergency.EmergencySupplies;
import com.example.demo.service.emergency.EmergencySuppliesService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * 应急物资管理
 * @author zld
 * date: 2020/10/10
 * version: 02.06
 */
@Validated
@RestController
@RequestMapping("api/emergency/supplies")
public class EmergencySuppliesController {
    private final EmergencySuppliesService emergencySuppliesService;

    public EmergencySuppliesController(EmergencySuppliesService emergencySuppliesService) {
        this.emergencySuppliesService = emergencySuppliesService;
    }

    /**
     * 分页查询
     * @param reserveName
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/query")
    public ResponseEntity queryAllByPage(@RequestParam(value = "reserveName") String reserveName,
                                         @RequestParam(value = "page") Integer page,
                                         @RequestParam(value = "size") Integer size){
        Pageable pageable = page != null && size != null ? PageRequest.of(page, size) : Pageable.unpaged();
        return new ResponseEntity<>(emergencySuppliesService.queryAllPage(reserveName,pageable), HttpStatus.OK);
    }

    /**
     * 查询唯一
     * @param id
     */
    @GetMapping(value = "/queryOne")
    public ResponseEntity queryOne(@RequestParam @NotNull Long id){
        return new ResponseEntity<>(emergencySuppliesService.queryOne(id),HttpStatus.OK);
    }

    /**
     * 新增或修改
     * @param emergencySupplies
     */
    @PostMapping(value = "/insertOrUpdate")
    public void saveOrUpdate(@RequestBody EmergencySupplies emergencySupplies){
        if(null == emergencySupplies.getId()) {
            emergencySuppliesService.save(emergencySupplies);
        }else {
            emergencySuppliesService.update(emergencySupplies);
        }
    }

    /**
     * 删除
     * @param id
     */
    @GetMapping(value = "/delete")
    public void delete(@RequestParam @NotNull Long id){
        emergencySuppliesService.delete(id);
    }

}
