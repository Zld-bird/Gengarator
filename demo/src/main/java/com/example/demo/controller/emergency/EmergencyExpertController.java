package com.example.demo.controller.emergency;

import com.example.demo.entity.emergency.EmergencyExpert;
import com.example.demo.service.emergency.EmergencyExpertService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * 应急专家管理
 * @author zld
 * date: 2020/10/9
 * version: 02.06
 */
@Validated
@RestController
@RequestMapping("api/emergency/expert")
public class EmergencyExpertController {
    private final EmergencyExpertService emergencyExpertService;

    public EmergencyExpertController(EmergencyExpertService emergencyExpertService) {
        this.emergencyExpertService = emergencyExpertService;
    }

    /**
     * 分页查询
     * @param expertName
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/query")
    public ResponseEntity queryAllByPage(@RequestParam(value = "expertName") String expertName,
                                         @RequestParam(value = "page") Integer page,
                                         @RequestParam(value = "size") Integer size){
        Pageable pageable = page != null && size != null ? PageRequest.of(page, size) : Pageable.unpaged();
        return new ResponseEntity<>(emergencyExpertService.queryAllPage(expertName,pageable), HttpStatus.OK);
    }

    /**
     * 查询唯一
     * @param id
     */
    @GetMapping(value = "/queryOne")
    public ResponseEntity queryOne(@RequestParam @NotNull Long id){
        return new ResponseEntity<>(emergencyExpertService.queryOne(id),HttpStatus.OK);
    }

    /**
     * 新增或修改
     * @param emergencyExpert
     */
    @PostMapping(value = "/insertOrUpdate")
    public void saveOrUpdate(@RequestBody EmergencyExpert emergencyExpert){
        if(null == emergencyExpert.getId()) {
            emergencyExpertService.save(emergencyExpert);
        }else {
            emergencyExpertService.update(emergencyExpert);
        }
    }

    /**
     * 删除
     * @param id
     */
    @GetMapping(value = "/delete")
    public void delete(@RequestParam @NotNull Long id){
        emergencyExpertService.delete(id);
    }

}
