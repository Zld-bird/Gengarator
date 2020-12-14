package com.example.demo.mapper.emergency;

import com.example.demo.entity.emergency.EmergencyOrganization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmergencyOrganizationRepository extends JpaSpecificationExecutor<EmergencyOrganization>, JpaRepository<EmergencyOrganization,Long> {

    /**
     * 查询应急机构列表
     * @param corpName
     * @return
     */
    @Query(value = "SELECT " +
            "  org.id, " +
            "   IF(IFNULL(org.organization_name,'')='','0',org.organization_name) as organizationName, " +
            "   GROUP_CONCAT(m.id,';', m.charge_man, ';', m.position, ';', IF(IFNULL(m.telephone,'')='','0',m.telephone)  ) AS chargeMan, " +
            "   IF(IFNULL(org.duty_fax,'')= '','0',org.duty_fax) as dutyFax, " +
            "   IF(IFNULL(org.duty_telephone,'')= '','0',org.duty_telephone) as dutyPhone, " +
            "   IF(IFNULL(org.email,'')= '','0',org.email) as email, " +
            "   IF(IFNULL(org.telephone,'')= '','0',org.telephone) as telephone, " +
            "   IF(IFNULL(org.longitude,'')= '','0',org.longitude) as longitude, " +
            "   IF(IFNULL(org.latitude,'')= '','0',org.latitude) as latitude, " +
            "   IF(IFNULL(org.establish_date,'')= '','0',org.establish_date) as establishDate, " +
            "   IF(IFNULL(org.address,'')= '','0',org.address) as address ," +
            "   GROUP_CONCAT(IF(IFNULL(eom.id,'')='','0',eom.id),';',IF(IFNULL(eom.member_id,'')='','0',eom.member_id)) AS eomId " +
            " FROM " +
            " emergency_organization org " +
            " LEFT JOIN emergency_org_member eom ON org.id = eom.organization_id " +
            " left join emergency_member m ON m.id=eom.member_id " +
            " WHERE org.is_del = 1 and IF(?1 is not null or ?1 != '',org.organization_name like CONCAT(?1,'%'), 1=1) " +
            " GROUP BY org.id " +
            " order by establish_date desc ",
            countQuery ="select count(org.id) from emergency_organization org " +
                    "where org.is_del = 1 and " +
                    "IF(?1 is not null or ?1 != '', org.organization_name like CONCAT(?1,'%'),1=1)",nativeQuery = true)
    Page<Object[]> queryPageList(String corpName, Pageable pageable);

    /**
     * 修改删除状态为删除
     * @param id
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "update emergency_organization set is_del=0 where id=?1",nativeQuery = true)
    int deleteEmergency(Long id);

    /**
     * 修改机构信息
     * @param emergencyOrganization
     */
    @Modifying
    @Transactional
    @Query(value = " update emergency_organization set  " +
            " organization_name = CASE WHEN :#{#emergencyOrganization.organizationName} IS NOT  NULL THEN :#{#emergencyOrganization.organizationName} ELSE organization_name end, " +
            " address = CASE WHEN :#{#emergencyOrganization.address} IS NOT  NULL THEN :#{#emergencyOrganization.address} ELSE address end, " +
            " establish_date = CASE WHEN :#{#emergencyOrganization.establishDate} IS NOT  NULL THEN :#{#emergencyOrganization.establishDate} ELSE establish_date end," +
            " telephone = CASE WHEN :#{#emergencyOrganization.telephone} IS NOT  NULL THEN :#{#emergencyOrganization.telephone} ELSE telephone end," +
            " email = CASE WHEN :#{#emergencyOrganization.email} IS NOT  NULL THEN :#{#emergencyOrganization.email} ELSE email end," +
            " duty_fax = CASE WHEN :#{#emergencyOrganization.dutyFax} IS NOT  NULL THEN :#{#emergencyOrganization.dutyFax} ELSE duty_fax end," +
            " duty_telephone = CASE WHEN :#{#emergencyOrganization.dutyTelephone} IS NOT  NULL THEN :#{#emergencyOrganization.dutyTelephone} ELSE duty_telephone end," +
            " longitude = CASE WHEN :#{#emergencyOrganization.longitude} IS NOT  NULL THEN :#{#emergencyOrganization.longitude} ELSE longitude end," +
            " latitude = CASE WHEN :#{#emergencyOrganization.latitude} IS NOT  NULL THEN :#{#emergencyOrganization.latitude} ELSE latitude end," +
            " is_del = CASE WHEN :#{#emergencyOrganization.isDel} IS NOT  NULL THEN :#{#emergencyOrganization.isDel} ELSE is_del end," +
            " create_time = CASE WHEN :#{#emergencyOrganization.createTime} IS NOT  NULL THEN :#{#emergencyOrganization.createTime} ELSE create_time end," +
            " update_time = CASE WHEN :#{#emergencyOrganization.updateTime} IS NOT  NULL THEN :#{#emergencyOrganization.updateTime} ELSE update_time end" +
            " where id=:#{#emergencyOrganization.id} " ,nativeQuery = true)
    void updateEmergencyOrgInfo(@Param("emergencyOrganization") EmergencyOrganization emergencyOrganization);

    /**
     * 查询唯一
     * @param orgId
     * @return
     */
    @Query(value = " select  org.id,    " +
            "   IF(IFNULL(org.organization_name,'')= '','0',org.organization_name) as organizationName,    " +
            "   GROUP_CONCAT(m.id,';', m.charge_man, ';', m.position, ';', IF(IFNULL(m.telephone,'')='','0',m.telephone)) AS chargeMan,    " +
            "   IF(IFNULL(org.duty_fax,'')= '','0',org.duty_fax) as dutyFax, " +
            "   IF(IFNULL(org.duty_telephone,'')= '','0',org.duty_telephone) as dutyPhone, " +
            "   IF(IFNULL(org.email,'')= '','0',org.email) as email, " +
            "   IF(IFNULL(org.telephone,'')= '','0',org.telephone) as telephone, " +
            "   IF(IFNULL(org.longitude,'')= '','0',org.longitude) as longitude, " +
            "   IF(IFNULL(org.latitude,'')= '','0',org.latitude) as latitude, " +
            "   IF(IFNULL(org.establish_date,'')= '','0',org.establish_date) as establishDate, " +
            "   IF(IFNULL(org.address,'')= '','0',org.address) as address, " +
            "   GROUP_CONCAT(IF(IFNULL(eom.id,'')='','0',eom.id),';',IF(IFNULL(eom.member_id,'')='','0',eom.member_id)) AS eomId " +
            "  FROM    " +
            "   emergency_organization org    " +
            "   LEFT JOIN emergency_org_member eom ON org.id = eom.organization_id    " +
            "   LEFT JOIN emergency_member m ON m.id=eom.member_id    " +
            "  WHERE org.is_del = 1 and org.id=?1 ",nativeQuery = true)
    List<Object[]> queryOne(Long orgId);

}
