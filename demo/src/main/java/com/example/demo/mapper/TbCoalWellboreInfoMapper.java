package com.example.demo.mapper;


import com.example.demo.entity.TbCoalWellboreInfo;
import com.fasterxml.jackson.annotation.JsonMerge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TbCoalWellboreInfoMapper extends JpaRepository<TbCoalWellboreInfo,Long> , JpaSpecificationExecutor<TbCoalWellboreInfo> {

    @Query(value = "select id, wellbore_name, coalmine_number,  " +
            "      vertical_depth, section_area, wellbore_coordinateX,  " +
            "      wellbore_coordinateY, wellbore_coordinateZ,  " +
            "      angle, support_method, hoist_model,  " +
            "      wellbore_type, is_delete, add_time,  " +
            "      add_user_id, add_username, update_time,  " +
            "      up_user_id, update_username from tb_coal_wellbore_info where is_delete=1",nativeQuery = true)
    List<TbCoalWellboreInfo> findWellboreList();

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Query(value = "insert into tb_coal_wellbore_info (wellbore_name, coalmine_number,  " +
            "      vertical_depth, section_area, wellbore_coordinateX,  " +
            "      wellbore_coordinateY, wellbore_coordinateZ,  " +
            "      angle, support_method, hoist_model,  " +
            "      wellbore_type, is_delete, add_time,  " +
            "      add_user_id, add_username, update_time,  " +
            "      up_user_id, update_username) values (:#{#coalWellboreInfo.wellboreName},:#{#coalWellboreInfo.coalmineNumber}," +
            " :#{#coalWellboreInfo.verticalDepth},:#{#coalWellboreInfo.sectionArea},:#{#coalWellboreInfo.wellboreCoordinatex}," +
            " :#{#coalWellboreInfo.wellboreCoordinatey},:#{#coalWellboreInfo.wellboreCoordinatez},:#{#coalWellboreInfo.angle}," +
            " :#{#coalWellboreInfo.supportMethod},:#{#coalWellboreInfo.hoistModel},:#{#coalWellboreInfo.wellboreType}," +
            " :#{#coalWellboreInfo.isDelete},:#{#coalWellboreInfo.addTime},:#{#coalWellboreInfo.addUserId}," +
            " :#{#coalWellboreInfo.addUsername},:#{#coalWellboreInfo.updateTime},:#{#coalWellboreInfo.upUserId}," +
            " :#{#coalWellboreInfo.updateUsername})",nativeQuery = true)
    int insertWellboreInfo(@Param("coalWellboreInfo") TbCoalWellboreInfo coalWellboreInfo);
}