package com.example.demo.mapper;


import com.example.demo.entity.TbCoalAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TbCoalAttributeMapper extends JpaRepository<TbCoalAttribute, Long>, JpaSpecificationExecutor<TbCoalAttribute> {
   /* int insert(TbCoalAttribute record);

    int insertSelective(TbCoalAttribute record);
*/
    @Query(value = "select id, coalmine_code, proved_output,  " +
            "      product_date, build_time, mine_style,  " +
            "      mini_technology, level_high, geo_type,  " +
            "      approved_mine_depth, rock_burst, geohazard_type,  " +
            "      grime_explosive, ws_grade, hydrogeological_type,  " +
            "      water_burst_max, is_build_monitor, drainage_way,  " +
            "      is_replace_new_mine, is_replace_replaced_mine,  " +
            "      is_plan_exit_mine, trans_type, trans_description,  " +
            "      power_style, power_description, ventilate_style,  " +
            "      ventilate_description, coal_fire, fire_description,  " +
            "      traffic_condition, rf_lithology, neigh_mine,  " +
            "      mine_range, mine_area, geo_overview,  " +
            "      is_delete, add_time, add_user_id,  " +
            "      add_username, update_time, up_user_id,  " +
            "      update_username from tb_coal_attribute",nativeQuery = true)
    TbCoalAttribute findCorpAttributeInfoByCoalmineCode();
}