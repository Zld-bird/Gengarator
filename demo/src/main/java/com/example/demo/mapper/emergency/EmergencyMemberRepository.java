package com.example.demo.mapper.emergency;

import com.example.demo.entity.emergency.EmergencyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmergencyMemberRepository extends JpaRepository<EmergencyMember,Long>, JpaSpecificationExecutor {

    /**
     * 修改机构成员信息
     * @param emergencyMember
     */
    @Modifying
    @Transactional
    @Query(value = "update emergency_member set " +
            " charge_man= case when :#{#emergencyMember.chargeMan} is not null then :#{#emergencyMember.chargeMan} else charge_man end," +
            " telephone= case when :#{#emergencyMember.telephone} is not null then :#{#emergencyMember.telephone} else telephone end," +
            " update_time= case when :#{#emergencyMember.updateTime} is not  null then :#{#emergencyMember.updateTime} else update_time end " +
            " where id=:#{#emergencyMember.id}",nativeQuery = true)
    void updateMember(@Param("emergencyMember") EmergencyMember emergencyMember);

    /**
     * 按照负责人和手机号查询成员id（主管领导）
     * @param supervisorName
     * @param supervisorPhone
     * @return
     */
    @Query(value = "select id from emergency_member where charge_man=?1 and telephone=?2",nativeQuery = true)
    Long findSupervisorByName(String supervisorName, String supervisorPhone);

    /**
     * 按照负责人和手机号查询成员id（分管领导）
     * @param chargeName
     * @param chargePhone
     * @return
     */
    @Query(value = "select id from emergency_member where charge_man=?1 and telephone=?2",nativeQuery = true)
    Long findChargeByName(String chargeName, String chargePhone);

}
