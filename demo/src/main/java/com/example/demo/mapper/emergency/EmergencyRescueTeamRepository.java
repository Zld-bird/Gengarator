package com.example.demo.mapper.emergency;

import com.example.demo.entity.emergency.EmergencyRescueTeam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmergencyRescueTeamRepository extends JpaRepository<EmergencyRescueTeam,Long> , JpaSpecificationExecutor<EmergencyRescueTeam> {
    /**
     * 分页查询
     * @param teamName
     * @param pageable
     * @return
     */
    @Query(value = " SELECT " +
            " emergencyr0_.id, " +
            " emergencyr0_.car_number, " +
            " emergencyr0_.charge_man, " +
            " emergencyr0_.charge_phone, " +
            " emergencyr0_.create_time, " +
            " emergencyr0_.duty_fax, " +
            " emergencyr0_.duty_phone, " +
            " emergencyr0_.email, " +
            " emergencyr0_.equipment_description, " +
            " emergencyr0_.establish_date, " +
            " emergencyr0_.fax, " +
            " emergencyr0_.good_type, " +
            " emergencyr0_.latitude, " +
            " emergencyr0_.longitude, " +
            " emergencyr0_.parent_unit, " +
            " emergencyr0_.phone, " +
            " emergencyr0_.team_name, " +
            " emergencyr0_.team_number, " +
            " emergencyr0_.team_type, " +
            " emergencyr0_.is_del,  " +
            " emergencyr0_.address,  " +
            " emergencyr0_.update_time " +
            "FROM " +
            " emergency_rescue_team emergencyr0_  " +
            "WHERE " +
            " IF(?1 is not null or ?1 != '', emergencyr0_.team_name LIKE CONCAT(?1 , '%') , 1=1) and emergencyr0_.is_del = 1 " +
            " order by emergencyr0_.establish_date desc " ,
            countQuery = "select count(emergencyr0_.id) from emergency_rescue_team emergencyr0_ " +
                    " where IF(?1 is not null or ?1 != '', emergencyr0_.team_name LIKE CONCAT(?1 , '%') , 1=1) and emergencyr0_.is_del = 1 " , nativeQuery = true)
    Page<EmergencyRescueTeam> queryAllByPage(String teamName, Pageable pageable);

    /**
     * 修改删除状态为已删除
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "update emergency_rescue_team set is_del=0 where id=?1",nativeQuery = true)
    void updateOneById(String id);

    /**
     * 修改信息
     * @param emergencyRescueTeam
     */
    @Modifying
    @Transactional
    @Query(value = "update emergency_rescue_team set " +
            " team_name = CASE WHEN :#{#emergencyRescueTeam.teamName} is not null THEN :#{#emergencyRescueTeam.teamName} ELSE team_name END, " +
            " parent_unit = CASE WHEN :#{#emergencyRescueTeam.parentUnit} is not null THEN :#{#emergencyRescueTeam.parentUnit} ELSE parent_unit END," +
            " team_number = CASE WHEN :#{#emergencyRescueTeam.teamNumber} is not null THEN :#{#emergencyRescueTeam.teamNumber} ELSE team_number END," +
            " team_type = CASE WHEN :#{#emergencyRescueTeam.teamType} is not null THEN :#{#emergencyRescueTeam.teamType} ELSE team_type END," +
            " charge_man = CASE WHEN :#{#emergencyRescueTeam.chargeMan} is not null THEN :#{#emergencyRescueTeam.chargeMan} ELSE charge_man END," +
            " charge_phone = CASE WHEN :#{#emergencyRescueTeam.chargePhone} is not null THEN :#{#emergencyRescueTeam.chargePhone} ELSE charge_phone END," +
            " phone = CASE WHEN :#{#emergencyRescueTeam.phone} is not null THEN :#{#emergencyRescueTeam.phone} ELSE phone END," +
            " duty_phone = CASE WHEN :#{#emergencyRescueTeam.dutyPhone} is not null THEN :#{#emergencyRescueTeam.dutyPhone} ELSE duty_phone END," +
            " fax = CASE WHEN :#{#emergencyRescueTeam.fax} is not null THEN :#{#emergencyRescueTeam.fax} ELSE fax END," +
            " duty_fax = CASE WHEN :#{#emergencyRescueTeam.dutyFax} is not null THEN :#{#emergencyRescueTeam.dutyFax} ELSE duty_fax END," +
            " car_number = CASE WHEN :#{#emergencyRescueTeam.carNumber} is not null THEN :#{#emergencyRescueTeam.carNumber} ELSE car_number END," +
            " good_type = CASE WHEN :#{#emergencyRescueTeam.goodType} is not null THEN :#{#emergencyRescueTeam.goodType} ELSE good_type END," +
            " equipment_description = CASE WHEN :#{#emergencyRescueTeam.equipmentDescription} is not null THEN :#{#emergencyRescueTeam.equipmentDescription} ELSE equipment_description END," +
            " address = CASE WHEN :#{#emergencyRescueTeam.address} is not null THEN :#{#emergencyRescueTeam.address} ELSE address END," +
            " establish_date = CASE WHEN :#{#emergencyRescueTeam.establishDate} is not null THEN :#{#emergencyRescueTeam.establishDate} ELSE establish_date END," +
            " email = CASE WHEN :#{#emergencyRescueTeam.email} is not null THEN :#{#emergencyRescueTeam.email} ELSE email END," +
            " longitude = CASE WHEN :#{#emergencyRescueTeam.longitude} is not null THEN :#{#emergencyRescueTeam.longitude} ELSE longitude END," +
            " latitude = CASE WHEN :#{#emergencyRescueTeam.latitude} is not null THEN :#{#emergencyRescueTeam.latitude} ELSE latitude END," +
            " is_del = CASE WHEN :#{#emergencyRescueTeam.isDel} is not null THEN :#{#emergencyRescueTeam.isDel} ELSE is_del END," +
            " create_time = CASE WHEN :#{#emergencyRescueTeam.createTime} is not null THEN :#{#emergencyRescueTeam.createTime} ELSE create_time END, " +
            " update_time = CASE WHEN :#{#emergencyRescueTeam.updateTime} is not null THEN :#{#emergencyRescueTeam.updateTime} ELSE update_time END " +
            " where id=?1",nativeQuery = true)
    void updateTeamInfo(@Param("emergencyRescueTeam") EmergencyRescueTeam emergencyRescueTeam);
}
