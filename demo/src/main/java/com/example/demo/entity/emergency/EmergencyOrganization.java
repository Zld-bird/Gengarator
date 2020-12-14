package com.example.demo.entity.emergency;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 应急机构表
 */
@Data
@Entity
@Table(name = "emergency_organization")
public class EmergencyOrganization implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 应急指挥机构名称
     */
    @Column(name = "organization_name")
    private String organizationName;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 成立日期
     */
    @Column(name = "establish_date")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private String establishDate;

    /**
     * 电话
     */
    @Column(name = "telephone")
    private String telephone;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 值班传真
     */
    @Column(name = "duty_fax")
    private String dutyFax;

    /**
     * 值班电话
     */
    @Column(name = "duty_telephone")
    private String dutyTelephone;

    /**
     * 经度
     */
    @Column(name = "longitude")
    private String longitude;
    /**
     * 纬度
     */
    @Column(name = "latitude")
    private String latitude;

    /**
     * 是否删除 0 否 1 是
     */
    @Column(name = "is_del")
    private Integer isDel;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT+8")
    @Temporal(TemporalType.TIME)
    private Date updateTime;

}
