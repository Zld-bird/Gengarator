package com.example.demo.mapper.emergency;

import com.example.demo.entity.emergency.EmergencyEquipment;
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
public interface EmergencyEquipmentRepository extends JpaRepository<EmergencyEquipment,Long> , JpaSpecificationExecutor<EmergencyEquipment> {
    @Query(value = "SELECT " +
            " emergencye0_.id, " +
            " emergencye0_.buy_date, " +
            " emergencye0_.create_time, " +
            " emergencye0_.equipment_name, " +
            " emergencye0_.equipment_type, " +
            " emergencye0_.factory, " +
            " emergencye0_.factory_date, " +
            " emergencye0_.is_del, " +
            " emergencye0_.latitude, " +
            " emergencye0_.longitude, " +
            " emergencye0_.model, " +
            " emergencye0_.numbers, " +
            " emergencye0_.parent_corp, " +
            " emergencye0_.performance, " +
            " emergencye0_.price, " +
            " emergencye0_.specification, " +
            " emergencye0_.unit, " +
            " emergencye0_.update_time, " +
            " emergencye0_.use_on, " +
            " emergencye0_.use_year    " +
            "FROM " +
            " emergency_equipment emergencye0_"+
            " WHERE " +
            " IF(?1 is not null or ?1 != '', emergencye0_.equipment_name LIKE CONCAT(?1 , '%') , 1=1) and emergencye0_.is_del = 1 " +
            " order by emergencye0_.factory_date desc " ,
            countQuery = "select count(emergencye0_.id) from emergency_expert emergencye0_ " +
                    " where IF(?1 is not null or ?1 != '', emergencye0_.equipment_name LIKE CONCAT(?1 , '%') , 1=1) and emergencye0_.is_del = 1 ",nativeQuery = true)
    Page<EmergencyEquipment> queryAll(String equipmentName, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update emergency_equipment set " +
            " buy_date = case when :#{#emergencyEquipment.buyDate} is not null then :#{#emergencyEquipment.buyDate} else buy_date end," +
            " equipment_name = case when :#{#emergencyEquipment.equipmentName} is not null then :#{#emergencyEquipment.equipmentName} else equipment_name end," +
            " equipment_type = case when :#{#emergencyEquipment.equipmentType} is not null then :#{#emergencyEquipment.equipmentType} else equipment_type end," +
            " factory = case when :#{#emergencyEquipment.factory} is not null then :#{#emergencyEquipment.factory} else factory end," +
            " factory_date = case when :#{#emergencyEquipment.factoryDate} is not null then :#{#emergencyEquipment.factoryDate} else factory_date end," +
            " model = case when :#{#emergencyEquipment.model} is not null then :#{#emergencyEquipment.model} else model end," +
            " numbers = case when :#{#emergencyEquipment.numbers} is not null then :#{#emergencyEquipment.numbers} else numbers end," +
            " parent_corp = case when :#{#emergencyEquipment.parentCorp} is not null then :#{#emergencyEquipment.parentCorp} else parent_corp end," +
            " performance = case when :#{#emergencyEquipment.performance} is not null then :#{#emergencyEquipment.performance} else performance end," +
            " price = case when :#{#emergencyEquipment.price} is not null then :#{#emergencyEquipment.price} else price end," +
            " specification = case when :#{#emergencyEquipment.specification} is not null then :#{#emergencyEquipment.specification} else specification end," +
            " unit = case when :#{#emergencyEquipment.unit} is not null then :#{#emergencyEquipment.unit} else unit end," +
            " use_on = case when :#{#emergencyEquipment.useOn} is not null then :#{#emergencyEquipment.useOn} else use_on end," +
            " use_year = case when :#{#emergencyEquipment.useYear} is not null then :#{#emergencyEquipment.useYear} else use_year end," +
            " longitude=CASE WHEN :#{#emergencyEquipment.longitude} is not null THEN :#{#emergencyEquipment.longitude} ELSE longitude END, " +
            " latitude=CASE WHEN :#{#emergencyEquipment.latitude} is not null THEN :#{#emergencyEquipment.latitude} ELSE latitude END, " +
            " is_del = CASE WHEN :#{#emergencyEquipment.isDel} is not null THEN :#{#emergencyEquipment.isDel} ELSE is_del END," +
            " create_time = CASE WHEN :#{#emergencyEquipment.createTime} is not null THEN :#{#emergencyEquipment.createTime} ELSE create_time END, " +
            " update_time = CASE WHEN :#{#emergencyEquipment.updateTime} is not null THEN :#{#emergencyEquipment.updateTime} ELSE update_time END " +
            " where id=:#{#emergencyEquipment.id}",nativeQuery = true)
    void update(@Param("emergencyEquipment") EmergencyEquipment emergencyEquipment);

    @Modifying
    @Transactional
    @Query(value = "update emergency_equipment set is_del=0 where id=?1",nativeQuery = true)
    void updateOneById(Long id);
}
