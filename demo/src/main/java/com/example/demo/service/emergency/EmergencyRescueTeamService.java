package com.example.demo.service.emergency;

import com.example.demo.entity.emergency.EmergencyRescueTeam;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * 应急救援队伍
 */
public interface EmergencyRescueTeamService {
    /**
     * 分页查询
     * @param teamName
     * @param pageable
     * @return
     */
    Map<String,Object> queryPage(String teamName, Pageable pageable);

    /**
     * 修改救援队伍信息
     * @param emergencyRescueTeam
     */
    void updateTeamInfo(EmergencyRescueTeam emergencyRescueTeam);

    /**
     * 新增救援队伍
     * @param emergencyRescueTeam
     */
    void insertTeamInfo(EmergencyRescueTeam emergencyRescueTeam);

    /**
     * 根据队伍id查询
     * @param id
     * @return
     */
    EmergencyRescueTeam queryOne(Long id);

    /**
     * 逻辑删除
     * @param id
     */
    void delete(String id);
}
