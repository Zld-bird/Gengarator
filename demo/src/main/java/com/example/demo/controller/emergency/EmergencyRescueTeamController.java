package com.example.demo.controller.emergency;

import com.example.demo.entity.emergency.EmergencyRescueTeam;
import com.example.demo.service.emergency.EmergencyRescueTeamService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * 应急救援队伍
 */
@Validated
@RestController
@RequestMapping("api/emergency/team")
public class EmergencyRescueTeamController {
    private final EmergencyRescueTeamService emergencyRescueTeamService;

    public EmergencyRescueTeamController(EmergencyRescueTeamService emergencyRescueTeamService) {
        this.emergencyRescueTeamService = emergencyRescueTeamService;
    }

    /**
     * 分页查询
     * @param teamName
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/query")
    public ResponseEntity queryPage(@RequestParam(value = "teamName") String teamName,
                                    @RequestParam(value = "page") Integer page,
                                    @RequestParam(value = "size") Integer size){
        Pageable pageable = page != null && size != null ? PageRequest.of(page, size) : Pageable.unpaged();
        return new ResponseEntity<>(emergencyRescueTeamService.queryPage(teamName,pageable), HttpStatus.OK);
    }
    /**
     * 新增或者修改
     * @param emergencyRescueTeam
     * @return
     */
    @PostMapping(value = "/insertOrUpdate")
    public void insertOrUpdateTeamInfo(@RequestBody EmergencyRescueTeam emergencyRescueTeam){
        if (null != emergencyRescueTeam.getId()) {
            emergencyRescueTeamService.updateTeamInfo(emergencyRescueTeam);
        } else {
            emergencyRescueTeamService.insertTeamInfo(emergencyRescueTeam);
        }
    }
    /**
     * 根据id查询唯一
     * @param id
     * @return
     */
    @GetMapping(value = "/queryOne")
    public ResponseEntity queryOne(@RequestParam @NotNull Long id){
        return new ResponseEntity<>(emergencyRescueTeamService.queryOne(id), HttpStatus.OK);
    }
    /**
     * 逻辑删除
     * @param id
     * @return
     */
    @GetMapping(value = "/delete")
    public void delete(@RequestParam @NotNull String id){
        emergencyRescueTeamService.delete(id);
    }
}
