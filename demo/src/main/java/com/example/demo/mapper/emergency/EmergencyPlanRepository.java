package com.example.demo.mapper.emergency;

import com.example.demo.entity.emergency.EmergencyPlan;
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
public interface EmergencyPlanRepository extends JpaRepository<EmergencyPlan,Long>,
        JpaSpecificationExecutor<EmergencyPlan> {
    /**
     * 分页查询
     * @param planName
     * @param pageable
     * @return
     */
    @Query(value = " SELECT " +
            " emergencyp0_.id, " +
            " emergencyp0_.create_time, " +
            " emergencyp0_.is_del, " +
            " emergencyp0_.parent_corp, " +
            " emergencyp0_.plan_code, " +
            " emergencyp0_.plan_name, " +
            " emergencyp0_.plan_type, " +
            " emergencyp0_.publish_date, " +
            " emergencyp0_.STATUS, " +
            " emergencyp0_.update_time " +
            "FROM " +
            " emergency_plan emergencyp0_  " +
            "WHERE " +
            " IF(?1 is not null or ?1 != '', emergencyp0_.plan_name LIKE CONCAT(?1 , '%') , 1=1) and emergencyp0_.is_del = 1 " +
            " order by emergencyp0_.publish_date desc " ,
            countQuery = "select count(emergencyp0_.id) from emergency_plan emergencyp0_ " +
                    " where IF(?1 is not null or ?1 != '', emergencyp0_.plan_name LIKE CONCAT(?1 , '%') , 1=1) and emergencyp0_.is_del = 1 " , nativeQuery = true)
    Page<EmergencyPlan> findAllPage(String planName, Pageable pageable);

    /**
     * 修改
     * @param emergencyPlan
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE emergency_plan SET " +
            " plan_name = CASE WHEN :#{#emergencyPlan.planName} is not null THEN :#{#emergencyPlan.planName} ELSE plan_name END, " +
            " parent_corp = CASE WHEN :#{#emergencyPlan.parentCorp} is not null THEN :#{#emergencyPlan.parentCorp} ELSE parent_corp END," +
            " plan_code = CASE WHEN :#{#emergencyPlan.planCode} is not null THEN :#{#emergencyPlan.planCode} ELSE plan_code END," +
            " plan_type = CASE WHEN :#{#emergencyPlan.planType} is not null THEN :#{#emergencyPlan.planType} ELSE plan_type END," +
            " status = CASE WHEN :#{#emergencyPlan.status} is not null THEN :#{#emergencyPlan.status} ELSE status END," +
            " is_del = CASE WHEN :#{#emergencyPlan.isDel} is not null THEN :#{#emergencyPlan.isDel} ELSE is_del END," +
            " publish_date = CASE WHEN :#{#emergencyPlan.publishDate} is not null THEN :#{#emergencyPlan.publishDate} ELSE publish_date END," +
            " create_time = CASE WHEN :#{#emergencyPlan.createTime} is not null THEN :#{#emergencyPlan.createTime} ELSE create_time END, " +
            " update_time = CASE WHEN :#{#emergencyPlan.updateTime} is not null THEN :#{#emergencyPlan.updateTime} ELSE update_time END " +
            " WHERE id = :#{#emergencyPlan.id} " , nativeQuery = true)
    void update(@Param("emergencyPlan") EmergencyPlan emergencyPlan);

    /**
     * 修改删除状态为删除
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE emergency_plan SET is_del = 0 where id = ?1 " , nativeQuery = true)
    void updateIsDel(Long id);


}
