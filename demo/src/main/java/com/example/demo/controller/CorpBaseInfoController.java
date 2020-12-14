package com.example.demo.controller;

import com.example.demo.entity.TbCoalAttribute;
import com.example.demo.entity.TbCorpBaseInfo;
import com.example.demo.service.CorpBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 企业基本信息控制器
 * @author zhangld
 * date: 2020/8/25
 * version: 02.06
 */
@RestController
@Api(value = "/api/corp",tags = "企业基本信息")
@RequestMapping("/api/corp")
@Slf4j
public class CorpBaseInfoController {

    private final CorpBaseInfoService corpBaseInfoService;


    public CorpBaseInfoController(CorpBaseInfoService corpBaseInfoService) {
        this.corpBaseInfoService = corpBaseInfoService;
    }

    /**
     * 查询企业基本信息
     * @return
     */
    @ApiOperation("查询企业基本信息")
    @GetMapping(value = "/find")
    public ResponseEntity<TbCorpBaseInfo> findCorpBaseInfo(){
        return new ResponseEntity<>(corpBaseInfoService.findCorpBaseInfoByCoalmineCode(), HttpStatus.OK);
    }

    /**
     * 查询企业属性信息
     * @return
     */
    @ApiOperation("查询企业属性信息")
    @GetMapping(value = "/findAttribute")
    public ResponseEntity<TbCoalAttribute> findCorpAttributeInfo(){
        return new ResponseEntity<>(corpBaseInfoService.findCorpAttributeInfoByCoalmineCode(), HttpStatus.OK);
    }

}
