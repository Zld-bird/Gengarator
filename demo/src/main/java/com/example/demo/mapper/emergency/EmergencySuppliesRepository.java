package com.example.demo.mapper.emergency;

import com.example.demo.entity.emergency.EmergencySupplies;
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
public interface EmergencySuppliesRepository extends JpaRepository<EmergencySupplies,Long>, JpaSpecificationExecutor<EmergencySupplies> {

    /**
     * 分页查询
     * @param reserveName
     * @param pageable
     * @return
     */
    @Query(value = "SELECT " +
            " emergencys0_.id, " +
            " emergencys0_.charge_man, " +
            " emergencys0_.charge_phone, " +
            " emergencys0_.create_time, " +
            " emergencys0_.duty_phone, " +
            " emergencys0_.is_del, " +
            " emergencys0_.latitude, " +
            " emergencys0_.longitude , " +
            " emergencys0_.main_materials, " +
            " emergencys0_.materials_type, " +
            " emergencys0_.parent_corp, " +
            " emergencys0_.reserve, " +
            " emergencys0_.reserve_name, " +
            " emergencys0_.reserve_type, " +
            " emergencys0_.update_time     " +
            "FROM " +
            " emergency_supplies emergencys0_  "+
            " WHERE " +
            " IF(?1 is not null or ?1 != '', emergencys0_.reserve_name LIKE CONCAT(?1 , '%') , 1=1) and emergencys0_.is_del = 1 " +
            " order by emergencys0_.create_time desc " ,
            countQuery = "select count(emergencys0_.id) from emergency_supplies emergencys0_ " +
                    " where IF(?1 is not null or ?1 != '', emergencys0_.reserve_name LIKE CONCAT(?1 , '%') , 1=1) and emergencys0_.is_del = 1 " , nativeQuery = true)
    Page<EmergencySupplies> queryAllByPage(String reserveName, Pageable pageable);

    /**
     * 修改
     * @param emergencySupplies
     */
    @Modifying
    @Transactional
    @Query(value = "update emergency_supplies set " +
            "  charge_man = case when :#{#emergencySupplies.chargeMan} is not null then :#{#emergencySupplies.chargeMan} else charge_man end , " +
            "  charge_phone = case when :#{#emergencySupplies.chargePhone} is not null then :#{#emergencySupplies.chargePhone} else charge_phone end , " +
            "  duty_phone = case when :#{#emergencySupplies.dutyPhone} is not null then :#{#emergencySupplies.dutyPhone} else duty_phone end , " +
            "  main_materials = case when :#{#emergencySupplies.mainMaterials} is not null then :#{#emergencySupplies.mainMaterials} else main_materials end , " +
            "  materials_type = case when :#{#emergencySupplies.materialsType} is not null then :#{#emergencySupplies.materialsType} else materials_type end , " +
            "  parent_corp = case when :#{#emergencySupplies.parentCorp} is not null then :#{#emergencySupplies.parentCorp} else parent_corp end , " +
            "  reserve = case when :#{#emergencySupplies.reserve} is not null then :#{#emergencySupplies.reserve} else reserve end , " +
            "  reserve_name = case when :#{#emergencySupplies.reserveName} is not null then :#{#emergencySupplies.reserveName} else reserve_name end , " +
            "  reserve_type = case when :#{#emergencySupplies.reserveType} is not null then :#{#emergencySupplies.reserveType} else reserve_type end , " +
            "  longitude = CASE WHEN :#{#emergencySupplies.longitude} is not null THEN :#{#emergencySupplies.longitude} ELSE longitude END," +
            "  latitude = CASE WHEN :#{#emergencySupplies.latitude} is not null THEN :#{#emergencySupplies.latitude} ELSE latitude END," +
            "  is_del = CASE WHEN :#{#emergencySupplies.isDel} is not null THEN :#{#emergencySupplies.isDel} ELSE is_del END," +
            "  create_time = CASE WHEN :#{#emergencySupplies.createTime} is not null THEN :#{#emergencySupplies.createTime} ELSE create_time END, " +
            "  update_time = CASE WHEN :#{#emergencySupplies.updateTime} is not null THEN :#{#emergencySupplies.updateTime} ELSE update_time END " +
            " where id=:#{#emergencySupplies.id} " , nativeQuery = true)
    void update(@Param("emergencySupplies") EmergencySupplies emergencySupplies);

    /**
     * 逻辑删除
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "update emergency_supplies set is_del=0 where id=?1" , nativeQuery = true)
    void updateOneById(Long id);

}
