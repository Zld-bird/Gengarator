package com.example.demo.entity.emergency;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zld
 * date: 2020/9/25
 * version: 02.06
 */
@Data
@Entity
@Table(name = "emergency_org_member")
public class EmergencyOrgMember implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "member_id")
    private Long memberId;
}
