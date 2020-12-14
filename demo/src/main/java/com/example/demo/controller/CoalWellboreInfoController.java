package com.example.demo.controller;

import com.example.demo.entity.TbCoalWellboreInfo;
import com.example.demo.service.CoalWellboreInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 井筒信息控制器
 * @author zhangld
 * date: 2020/8/27
 * version: 02.06
 */
@RestController
@Api(value = "/api/wellbore",tags = "企业基本信息")
@RequestMapping("/api/wellbore")
@Slf4j
public class CoalWellboreInfoController {
    private final CoalWellboreInfoService coalWellboreInfoService;

    public CoalWellboreInfoController(CoalWellboreInfoService coalWellboreInfoService) {
        this.coalWellboreInfoService = coalWellboreInfoService;
    }

    @ApiOperation(value = "查询井筒列表")
    @PostMapping(value = "/findList")
    public ResponseEntity<Object> findCoalWellboreList(){
        List<TbCoalWellboreInfo> coalWellboreList = coalWellboreInfoService.findCoalWellboreList();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",coalWellboreList);
        return new ResponseEntity<>( resultMap, HttpStatus.OK);
    }

    @ApiOperation(value = "添加井筒信息")
    @PostMapping(value = "/add")
    public ResponseEntity<Object> insertWellboreInfo(@ModelAttribute(value = "coalWellboreInfo") TbCoalWellboreInfo coalWellboreInfo){
        try{
            //int i=;
            return new ResponseEntity<>(coalWellboreInfoService.insertWellboreInfo(coalWellboreInfo),HttpStatus.OK);
        }catch (Exception e){
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("message", e.getMessage());
            return new ResponseEntity<>(resultMap,HttpStatus.BAD_REQUEST);
        }
    }
}
