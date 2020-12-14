package com.example.demo.service.serviceImpl.emergency;

import cn.hutool.core.lang.Dict;
import com.example.demo.entity.emergency.EmergencyRescueTeam;
import com.example.demo.mapper.emergency.EmergencyRescueTeamRepository;
import com.example.demo.service.emergency.EmergencyRescueTeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * 应急救援队伍
 */
@Service
@Slf4j
public class EmergencyRescueTeamServiceImpl implements EmergencyRescueTeamService {
    private final EmergencyRescueTeamRepository emergencyRescueTeamRepository;

    public EmergencyRescueTeamServiceImpl(EmergencyRescueTeamRepository emergencyRescueTeamRepository) {
        this.emergencyRescueTeamRepository = emergencyRescueTeamRepository;
    }

    /**
     * 分页查询
     * @param teamName
     * @param pageable
     * @return
     */
    @Override
    public Map<String, Object> queryPage(String teamName, Pageable pageable) {
        Page<EmergencyRescueTeam> emergencyRescueTeams = emergencyRescueTeamRepository.queryAllByPage(teamName, pageable);
        return Dict.create().set("content",emergencyRescueTeams.getContent()).set("total",emergencyRescueTeams.getTotalElements());
    }

    /**
     * 修改
     * @param emergencyRescueTeam
     */
    @Override
    public void updateTeamInfo(EmergencyRescueTeam emergencyRescueTeam) {
        emergencyRescueTeam.setUpdateTime(new Date());
        emergencyRescueTeamRepository.updateTeamInfo(emergencyRescueTeam);
    }

    /**
     * 新增
     * @param emergencyRescueTeam
     */
    @Override
    public void insertTeamInfo(EmergencyRescueTeam emergencyRescueTeam) {
        emergencyRescueTeam.setCreateTime(new Date());
        emergencyRescueTeam.setIsDel((byte)1);
        emergencyRescueTeamRepository.save(emergencyRescueTeam);
    }

    /**
     * 查询唯一
     * @param id
     * @return
     */
    @Override
    public EmergencyRescueTeam queryOne(Long id) {
        return emergencyRescueTeamRepository.findById(id).orElse(new EmergencyRescueTeam());
    }

    /**
     * 逻辑删除
     * @param id
     */
    @Override
    public void delete(String id) {
        emergencyRescueTeamRepository.updateOneById(id);
    }
}
