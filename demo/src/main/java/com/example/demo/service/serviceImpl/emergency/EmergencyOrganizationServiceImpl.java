package com.example.demo.service.serviceImpl.emergency;

import cn.hutool.core.lang.Dict;
import com.example.demo.entity.emergency.EmergencyMember;
import com.example.demo.entity.emergency.EmergencyOrgMember;
import com.example.demo.entity.emergency.EmergencyOrganization;
import com.example.demo.entity.emergency.EmergencyOrganizationVo;
import com.example.demo.mapper.emergency.EmergencyMemberRepository;
import com.example.demo.mapper.emergency.EmergencyOrgMemberRepository;
import com.example.demo.mapper.emergency.EmergencyOrganizationRepository;
import com.example.demo.service.emergency.EmergencyOrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author zld
 * date: 2020/9/22
 * version: 02.06
 */
@Slf4j
@Service
public class EmergencyOrganizationServiceImpl implements EmergencyOrganizationService {
    private final EmergencyOrganizationRepository emergencyOrganizationRepository;
    private final EmergencyOrgMemberRepository emergencyOrgMemberRepository;
    private final EmergencyMemberRepository emergencyMemberRepository;

    public EmergencyOrganizationServiceImpl(EmergencyOrganizationRepository emergencyOrganizationRepository,
                                            EmergencyOrgMemberRepository emergencyOrgMemberRepository,
                                            EmergencyMemberRepository emergencyMemberRepository) {
        this.emergencyOrganizationRepository = emergencyOrganizationRepository;
        this.emergencyOrgMemberRepository = emergencyOrgMemberRepository;
        this.emergencyMemberRepository = emergencyMemberRepository;
    }

    /**
     * 查询应急机构列表
     * @param organizationName
     * @param pageable
     * @return
     */
    @Override
    public Map<String, Object> queryPageList(String organizationName, Pageable pageable) {
        Page<Object[]> objectList = emergencyOrganizationRepository.queryPageList(organizationName,pageable);
        List<EmergencyOrganizationVo> emergencyOrganizationVos = entityFormat(objectList.getContent());
        return Dict.create().set("content",emergencyOrganizationVos).set("total",objectList.getTotalElements());
    }

    /**
     * 新增应急机构列表
     * @param emergencyOrganizationVo
     * @return
     */
    @Override
    public Map<String,Object> insertEmergency(EmergencyOrganizationVo emergencyOrganizationVo) {
        EmergencyOrganization emergencyCommand = new EmergencyOrganization();

        if(!emergencyOrganizationVo.getSupervisorName().isEmpty() && !emergencyOrganizationVo.getSupervisorPhone().isEmpty() &&
                !emergencyOrganizationVo.getChargeLeaderName().isEmpty() && !emergencyOrganizationVo.getChargeLeaderPhone().isEmpty()) {
            //处理应急机构数据并添加
            if (null != emergencyOrganizationVo) {
                //给机构实体赋值,并添加
                BeanUtils.copyProperties(emergencyOrganizationVo, emergencyCommand);
                emergencyCommand.setCreateTime(new Date());
                emergencyCommand.setIsDel(1);
                EmergencyOrganization save = emergencyOrganizationRepository.save(emergencyCommand);

                Long sLeaderInfo = querySLeaderId(emergencyOrganizationVo);
                Long cLeaderInfo = queryCLeaderId(emergencyOrganizationVo);

                //如果主管领导信息没有就添加
                if (null == sLeaderInfo) {
                    insertS(emergencyOrganizationVo,save.getId());
                } else {
                    emergencyOrgMemberRepository.saveOrgMember1(save.getId(), sLeaderInfo);
                }
                //如果分管领导信息没有就添加
                if (null == cLeaderInfo) {
                    insertC(emergencyOrganizationVo,save.getId());
                } else {
                    emergencyOrgMemberRepository.saveOrgMember2(save.getId(), cLeaderInfo);
                }
            }
        }else {
            Map<String, Object> objectObjectMap = new HashMap<>();
            objectObjectMap.put("msg","领导名称和手机不能为null");
            return objectObjectMap;
        }
        return new HashMap<>();
    }

    /**
     * 修改
     * @param emergencyOrganizationVo
     * @return
     */
    @Override
    public Map<String,Object> updateEmergency(EmergencyOrganizationVo emergencyOrganizationVo) {
        EmergencyOrganization emergencyCommand = new EmergencyOrganization();
        if(null != emergencyOrganizationVo) {
            //给机构实体赋值,并修改
            BeanUtils.copyProperties(emergencyOrganizationVo, emergencyCommand);
            emergencyCommand.setUpdateTime(new Date());
            emergencyCommand.setId(emergencyOrganizationVo.getOrgId());
            emergencyOrganizationRepository.updateEmergencyOrgInfo(emergencyCommand);

            if(!emergencyOrganizationVo.getSupervisorName().isEmpty() && !emergencyOrganizationVo.getSupervisorPhone().isEmpty() &&
                    !emergencyOrganizationVo.getChargeLeaderName().isEmpty() && !emergencyOrganizationVo.getChargeLeaderPhone().isEmpty()) {

                Long sLeaderInfo = querySLeaderId(emergencyOrganizationVo);
                Long cLeaderInfo = queryCLeaderId(emergencyOrganizationVo);
                if(null != sLeaderInfo){
                    emergencyOrgMemberRepository.updateById(emergencyOrganizationVo.getOrgMemberIdS(),emergencyOrganizationVo.getOrgId(),sLeaderInfo);
                }else {
                    emergencyOrgMemberRepository.deleteById(emergencyOrganizationVo.getOrgMemberIdS());
                    insertS(emergencyOrganizationVo,emergencyOrganizationVo.getOrgId());
                }
                if(null != cLeaderInfo){
                    emergencyOrgMemberRepository.updateById(emergencyOrganizationVo.getOrgMemberIdC(),emergencyOrganizationVo.getOrgId(),cLeaderInfo);
                }else {
                    emergencyOrgMemberRepository.deleteById(emergencyOrganizationVo.getOrgMemberIdC());
                    insertC(emergencyOrganizationVo,emergencyOrganizationVo.getOrgId());
                }
            }
        }
        return new HashMap();
    }

    /**
     * 根据姓名、手机号查询领导id（主管领导）
     * @param emergencyOrganizationVo
     * @return
     */
    private Long querySLeaderId(EmergencyOrganizationVo emergencyOrganizationVo){
        //按照姓名和手机号查询主管领导信息
        return emergencyMemberRepository.findSupervisorByName(emergencyOrganizationVo.getSupervisorName(),
                emergencyOrganizationVo.getSupervisorPhone());
    }

    /**
     * 根据姓名、手机号查询领导id（分管领导）
     * @param emergencyOrganizationVo
     * @return
     */
    private Long queryCLeaderId(EmergencyOrganizationVo emergencyOrganizationVo){
        //按照姓名和手机号查询分管领导
        return emergencyMemberRepository.findChargeByName(emergencyOrganizationVo.getChargeLeaderName(),
                emergencyOrganizationVo.getChargeLeaderPhone());
    }

    /**
     * 添加主管领导信息和中间表
     * @param emergencyOrganizationVo
     * @param orgId
     */
    private void insertS(EmergencyOrganizationVo emergencyOrganizationVo,Long orgId){
        EmergencyMember emergencyMemberS=new EmergencyMember();
        EmergencyOrgMember emergencyOrgMemberS = new EmergencyOrgMember();
        emergencyMemberS.setChargeMan(emergencyOrganizationVo.getSupervisorName());
        emergencyMemberS.setTelephone(emergencyOrganizationVo.getSupervisorPhone());
        emergencyMemberS.setCreateTime(new Date());
        emergencyMemberS.setPosition("主管领导");
        EmergencyMember member = emergencyMemberRepository.save(emergencyMemberS);

        //添加中间表
        emergencyOrgMemberS.setOrganizationId(orgId);
        emergencyOrgMemberS.setMemberId(member.getId());
        emergencyOrgMemberRepository.save(emergencyOrgMemberS);
    }

    /**
     * 添加分管领导信息和中间表
     * @param emergencyOrganizationVo
     * @param orgId
     */
    private void insertC(EmergencyOrganizationVo emergencyOrganizationVo,Long orgId){
        EmergencyMember emergencyMemberC=new EmergencyMember();
        EmergencyOrgMember emergencyOrgMemberC = new EmergencyOrgMember();
        emergencyMemberC.setChargeMan(emergencyOrganizationVo.getChargeLeaderName());
        emergencyMemberC.setTelephone(emergencyOrganizationVo.getChargeLeaderPhone());
        emergencyMemberC.setCreateTime(new Date());
        emergencyMemberC.setPosition("分管领导");
        EmergencyMember member1 = emergencyMemberRepository.save(emergencyMemberC);
        //添加中间表
        emergencyOrgMemberC.setOrganizationId(orgId);
        emergencyOrgMemberC.setMemberId(member1.getId());
        emergencyOrgMemberRepository.save(emergencyOrgMemberC);
    }

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    @Override
    public int deleteEmergency(Long id) {
        return emergencyOrganizationRepository.deleteEmergency(id);
    }

    /**
     * 根据orgId查询
     * @param orgId
     * @return
     */
    @Override
    public Map<String, Object> queryOne(Long orgId) {
        List<Object[]> objects = emergencyOrganizationRepository.queryOne(orgId);
        EmergencyOrganizationVo emergencyOrganizationVo=new EmergencyOrganizationVo();
        if(null != objects) {
            List<EmergencyOrganizationVo> emergencyOrganizationVos = entityFormat(objects);
            for(EmergencyOrganizationVo e:emergencyOrganizationVos){
                emergencyOrganizationVo.setOrgId(e.getOrgId());
                emergencyOrganizationVo.setCLeaderId(e.getCLeaderId());
                emergencyOrganizationVo.setSLeaderId(e.getSLeaderId());
                emergencyOrganizationVo.setOrgMemberIdS(e.getOrgMemberIdS());
                emergencyOrganizationVo.setOrgMemberIdC(e.getOrgMemberIdC());
                emergencyOrganizationVo.setOrganizationName(e.getOrganizationName());
                emergencyOrganizationVo.setEstablishDate(e.getEstablishDate());
                emergencyOrganizationVo.setAddress(e.getAddress());
                emergencyOrganizationVo.setTelephone(e.getTelephone());
                emergencyOrganizationVo.setEmail(e.getEmail());
                emergencyOrganizationVo.setSupervisorName(e.getSupervisorName());
                emergencyOrganizationVo.setSupervisorPhone(e.getSupervisorPhone());
                emergencyOrganizationVo.setChargeLeaderName(e.getChargeLeaderName());
                emergencyOrganizationVo.setChargeLeaderPhone(e.getChargeLeaderPhone());
                emergencyOrganizationVo.setDutyTelephone(e.getDutyTelephone());
                emergencyOrganizationVo.setDutyFax(e.getDutyFax());
                emergencyOrganizationVo.setLongitude(e.getLongitude());
                emergencyOrganizationVo.setLatitude(e.getLatitude());
            }
        }
        return Dict.create().set("content",emergencyOrganizationVo);
    }


    /**
     * 将Object[]类型转换成EmergencyOrganizationVo
     * @param objectList
     * @return List<EmergencyOrganizationVo>
     */
    private List<EmergencyOrganizationVo> entityFormat(List<Object[]> objectList){
        List<EmergencyOrganizationVo> emergencyCommands=new ArrayList<>();
        if(null != objectList && objectList.size()>0) {
            for (Object[] objects : objectList) {
                EmergencyOrganizationVo emergencyOrganizationVo = new EmergencyOrganizationVo();
                emergencyOrganizationVo.setOrgId(Long.valueOf(String.valueOf(objects[0])));
                emergencyOrganizationVo.setOrganizationName(objects[1].equals("0") ? "": (String) objects[1]);

                String chargeManStr = (String) objects[2];
                if (null!=chargeManStr) {
                    String[] chargeList = chargeManStr.split(",");
                    for (String c : chargeList) {
                        String[] split = c.split(";");
                        for (int i = 0; i < split.length; i++) {
                            if (split[2].equals("主管领导")) {
                                emergencyOrganizationVo.setSLeaderId(Long.parseLong(split[0]));
                                emergencyOrganizationVo.setSupervisorName(split[1]);
                                emergencyOrganizationVo.setSupervisorPhone(split[3].equals("0") ? "":split[3]);
                            }
                            if (split[2].equals("分管领导")) {
                                emergencyOrganizationVo.setCLeaderId(Long.parseLong(split[0]));
                                emergencyOrganizationVo.setChargeLeaderName(split[1]);
                                emergencyOrganizationVo.setChargeLeaderPhone(split[3].equals("0") ? "":split[3]);
                            }
                        }
                    }
                }
                emergencyOrganizationVo.setDutyFax(objects[3].equals("0") ? "":(String) objects[3]);
                emergencyOrganizationVo.setDutyTelephone(objects[4].equals("0") ? "" : (String) objects[4]);
                emergencyOrganizationVo.setEmail(objects[5].equals("0") ?"": (String) objects[5]);
                emergencyOrganizationVo.setTelephone(objects[6].equals("0")?"": (String) objects[6]);
                emergencyOrganizationVo.setLongitude(objects[7].equals("0")?"": (String) objects[7]);
                emergencyOrganizationVo.setLatitude(objects[8].equals("0")?"": (String) objects[8]);
                emergencyOrganizationVo.setEstablishDate(objects[9].equals("0")?"": (String) objects[9]);
                emergencyOrganizationVo.setAddress(objects[10].equals("0")?"": (String) objects[10]);

                String eomIds = (String) objects[11];
                if (null!=eomIds && !eomIds.equals("0")) {
                        String[] eomIdList = eomIds.split(",");
                        for (int i = 0; i < eomIdList.length; i++) {
                            String[] split = eomIdList[i].split(";");
                            if (!split[1].equals("0")){
                                EmergencyMember emergencyMember = emergencyMemberRepository.findById(Long.parseLong(split[1])).orElse(new EmergencyMember());
                                if (null != emergencyMember.getId()) {
                                    if (emergencyMember.getPosition().equals("主管领导")) {
                                        emergencyOrganizationVo.setOrgMemberIdS(Long.parseLong(split[0]));
                                    } else {
                                        emergencyOrganizationVo.setOrgMemberIdC(Long.parseLong(split[0]));
                                    }
                                }
                            }
                        }
                }
                emergencyCommands.add(emergencyOrganizationVo);
            }
        }
        return emergencyCommands;
    }
}
