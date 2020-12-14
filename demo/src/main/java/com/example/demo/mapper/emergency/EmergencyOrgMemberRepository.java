package com.example.demo.mapper.emergency;

import com.example.demo.entity.emergency.EmergencyOrgMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EmergencyOrgMemberRepository extends JpaRepository<EmergencyOrgMember,Long> {

    @Modifying
    @Transactional
    @Query(value = "insert into emergency_org_member (organization_id,member_id) values (?1,?2)",nativeQuery = true)
    void saveOrgMember1(Long orgId, Long memberId);

    @Modifying
    @Transactional
    @Query(value = "insert into emergency_org_member (organization_id,member_id) values (?1,?2)",nativeQuery = true)
    void saveOrgMember2(Long orgId, Long memberId2);

    @Modifying
    @Transactional
    @Query(value = "update emergency_org_member set organization_id=?2,member_id=?3 where id=?1",nativeQuery = true)
    void updateById(Long orgMemberIdS, Long orgId, Long sLeaderInfo);

   /* @Query(value = "select id from emergency_org_member where organization_id=?1 and member_id=?2 ",nativeQuery = true)
    Long findId(Long id, Long sLeaderInfo);*/
}
