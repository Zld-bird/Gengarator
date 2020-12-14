package com.example.demo.mapper;

import com.example.demo.entity.TbCorpBaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TbCorpBaseInfoMapper extends JpaRepository<TbCorpBaseInfo, Long>, JpaSpecificationExecutor<TbCorpBaseInfo> {

    @Query(value = "select id, corp_name, coalmine_number, corp_other_name, mine_type, build_state, corp_type, " +
            "    licence_state, chargeman, chargeman_phone, post_code, contacts, contacts_phone, " +
            "    dispatch_phone, management_level, mini_technology, top_corp_id,top_corp_name, economic_type_name, " +
            "    standard_grade, mine_class, mine_class_name, longitude, longitude_d, longitude_f, " +
            "    longitude_m, latitude, latitude_d, latitude_f, latitude_m, add_time, add_user_id, " +
            "    add_username, is_delete, update_time, up_user_id, update_username,address,email,explosive_description" +
            "    from tb_corp_base_info ",nativeQuery = true)
    TbCorpBaseInfo selectDetailByCoalmineCode();

    //int insert(TbCorpBaseInfo tbCorpBaseInfo);
}