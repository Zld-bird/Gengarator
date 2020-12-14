package com.example.demo.mapper.emergency;

import com.example.demo.entity.emergency.EmergencyExpert;
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
public interface EmergencyExpertRepository extends JpaRepository<EmergencyExpert,Long>, JpaSpecificationExecutor<EmergencyExpert> {

    /**
     * 分页查询
     * @param expertName
     * @param pageable
     * @return
     */
    @Query(value = "SELECT " +
            " emergencye0_.id, " +
            " emergencye0_.address, " +
            " emergencye0_.applicable_events, " +
            " emergencye0_.birthday, " +
            " emergencye0_.create_time, " +
            " emergencye0_.employer, " +
            " emergencye0_.employer_address, " +
            " emergencye0_.experience, " +
            " emergencye0_.expert_name, " +
            " emergencye0_.expert_type, " +
            " emergencye0_.fixed_phone, " +
            " emergencye0_.gender, " +
            " emergencye0_.is_del, " +
            " emergencye0_.job_status, " +
            " emergencye0_.latitude, " +
            " emergencye0_.longitude, " +
            " emergencye0_.nation, " +
            " emergencye0_.phone, " +
            " emergencye0_.update_time " +
            "FROM " +
            " emergency_expert emergencye0_"+
            " WHERE " +
            " IF(?1 is not null or ?1 != '', emergencye0_.expert_name LIKE CONCAT(?1 , '%') , 1=1) and emergencye0_.is_del = 1 " +
            " order by emergencye0_.birthday desc " ,
            countQuery = "select count(emergencye0_.id) from emergency_expert emergencye0_ " +
                    " where IF(?1 is not null or ?1 != '', emergencye0_.expert_name LIKE CONCAT(?1 , '%') , 1=1) and emergencye0_.is_del = 1 ",
            nativeQuery = true)
    Page<EmergencyExpert> queryAllByPage(String expertName, Pageable pageable);

    /**
     * 修改
     * @param emergencyExpert
     */
    @Modifying
    @Transactional
    @Query(value = "update emergency_expert set " +
            " expert_name=CASE WHEN :#{#emergencyExpert.expertName} is not null THEN :#{#emergencyExpert.expertName} ELSE expert_name END, " +
            " birthday=CASE WHEN :#{#emergencyExpert.birthday} is not null THEN :#{#emergencyExpert.birthday} ELSE birthday END," +
            " gender=CASE WHEN :#{#emergencyExpert.gender} is not null THEN :#{#emergencyExpert.gender} ELSE gender END, " +
            " nation=CASE WHEN :#{#emergencyExpert.nation} is not null THEN :#{#emergencyExpert.nation} ELSE nation END, " +
            " job_status=CASE WHEN :#{#emergencyExpert.jobStatus} is not null THEN :#{#emergencyExpert.jobStatus} ELSE job_status END, " +
            " fixed_phone=CASE WHEN :#{#emergencyExpert.fixedPhone} is not null THEN :#{#emergencyExpert.fixedPhone} ELSE fixed_phone END, " +
            " expert_type=CASE WHEN :#{#emergencyExpert.expertType} is not null THEN :#{#emergencyExpert.expertType} ELSE expert_type END, " +
            " applicable_events=CASE WHEN :#{#emergencyExpert.applicableEvents} is not null THEN :#{#emergencyExpert.applicableEvents} ELSE applicable_events END, " +
            " phone=CASE WHEN :#{#emergencyExpert.phone} is not null THEN :#{#emergencyExpert.phone} ELSE phone END, " +
            " experience=CASE WHEN :#{#emergencyExpert.experience} is not null THEN :#{#emergencyExpert.experience} ELSE experience END, " +
            " address=CASE WHEN :#{#emergencyExpert.address} is not null THEN :#{#emergencyExpert.address} ELSE address END, " +
            " employer=CASE WHEN :#{#emergencyExpert.employer} is not null THEN :#{#emergencyExpert.employer} ELSE employer END, " +
            " employer_address=CASE WHEN :#{#emergencyExpert.employerAddress} is not null THEN :#{#emergencyExpert.employerAddress } ELSE employer_address END, " +
            " longitude=CASE WHEN :#{#emergencyExpert.longitude} is not null THEN :#{#emergencyExpert.longitude} ELSE longitude END, " +
            " latitude=CASE WHEN :#{#emergencyExpert.latitude} is not null THEN :#{#emergencyExpert.latitude} ELSE latitude END, " +
            " is_del = CASE WHEN :#{#emergencyExpert.isDel} is not null THEN :#{#emergencyExpert.isDel} ELSE is_del END," +
            " create_time = CASE WHEN :#{#emergencyExpert.createTime} is not null THEN :#{#emergencyExpert.createTime} ELSE create_time END, " +
            " update_time = CASE WHEN :#{#emergencyExpert.updateTime} is not null THEN :#{#emergencyExpert.updateTime} ELSE update_time END " +
            " WHERE id = :#{#emergencyExpert.id} ",nativeQuery = true)
    void update(@Param("emergencyExpert") EmergencyExpert emergencyExpert);

    /**
     * 逻辑删除（将删除状态修改为已删除）
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "update emergency_expert set is_del=0 where id=?1",nativeQuery = true)
    void updateOneById(Long id);
}
