package com.example.demo.service.emergency;

import com.example.demo.entity.emergency.EmergencyOrganizationVo;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface EmergencyOrganizationService {
    /**
     * 查询应急机构列表
     * @param corpName
     * @param pageable
     * @return
     */
    Map<String,Object> queryPageList(String corpName, Pageable pageable);

    /**
     * 新增应急机构信息
     * @param emergencyOrganizationVo
     * @return
     */
    Map<String,Object> insertEmergency(EmergencyOrganizationVo emergencyOrganizationVo);

    /**
     * 修改机构信息
     * @param emergencyOrganizationVo
     */
    Map<String,Object> updateEmergency(EmergencyOrganizationVo emergencyOrganizationVo);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    int deleteEmergency(Long id);

    /**
     * 根据机构id查询
     * @param orgId
     * @return
     */
    Map<String,Object> queryOne(Long orgId);
}
