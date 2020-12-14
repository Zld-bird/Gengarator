package com.example.demo.entity.emergency;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zld
 * date: 2020/9/25
 * version: 02.06
 */
@Data
@Entity
@Table(name = "emergency_member")
public class EmergencyMember implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 成员单位名称
     */
    @Column(name="member_unit")
    private String memberUnit;
    /**
     * 负责人
     */
    @Column(name="charge_man")
    private String chargeMan;
    /**
     * 职务(0:主管领导，1:分管领导)
     */
    @Column(name="position")
    private String position;
    /**
     * 办公电话
     */
    @Column(name="telephone")
    private String telephone;
    /**
     * 备注
     */
    @Column(name="remark")
    private String remark;

    /**
     * 添加日期
     */
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改日期
     */
    @Column(name = "update_time")
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT+8")
    private Date updateTime;

}
