package com.example.demo.controller.emergency;

import com.example.demo.entity.emergency.EmergencyOrganizationVo;
import com.example.demo.service.emergency.EmergencyOrganizationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * 应急管理-应急机构管理模块controller
 * @author zld
 * date: 2020/9/22
 * version: 02.06
 */
@Validated
@RestController
@RequestMapping("api/emergency/manage")
public class EmergencyOrganizationController {
    private final EmergencyOrganizationService emergencyOrganizationService;

    public EmergencyOrganizationController(EmergencyOrganizationService emergencyOrganizationService) {
        this.emergencyOrganizationService = emergencyOrganizationService;
    }

    /**
     * 查询应急机构列表
     * @param orgName
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/query")
    public ResponseEntity queryPageList(@RequestParam(value = "orgName") String orgName,
                                        @RequestParam(value = "page") Integer page,
                                        @RequestParam(value = "size") Integer size){
        Pageable pageable = page != null && size != null ? PageRequest.of(page, size) : Pageable.unpaged();
        return new ResponseEntity<>(emergencyOrganizationService.queryPageList(orgName,pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/queryOne")
    public ResponseEntity queryOne(@NotNull Long orgId){
        return new ResponseEntity<>(emergencyOrganizationService.queryOne(orgId), HttpStatus.OK);
    }

    /**
     * 新增应急机构
     * @param emergencyOrganizationVo
     * @return
     */
    @PostMapping(value = "/insertOrUpdate")
    public ResponseEntity insertOrUpdateEmergency(@RequestBody EmergencyOrganizationVo emergencyOrganizationVo){
        if(null != emergencyOrganizationVo.getOrgId()) {
            return new ResponseEntity<>(emergencyOrganizationService.updateEmergency(emergencyOrganizationVo),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(emergencyOrganizationService.insertEmergency(emergencyOrganizationVo),HttpStatus.OK);
        }
    }

    /**
     * 逻辑删除
     * @param orgId
     * @return
     */
    @GetMapping(value = "/delete")
    public ResponseEntity deleteEmergency(@NotNull Long orgId){
        int i = emergencyOrganizationService.deleteEmergency(orgId);
        return new ResponseEntity<>(i==0?"删除失败":"删除成功", HttpStatus.OK);
    }

}
