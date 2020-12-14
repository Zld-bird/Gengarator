package com.example.demo.entity.emergency;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * 应急专家实体
 */
@Table(name = "emergency_expert")
@Entity
@Data
public class EmergencyExpert implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * 专家姓名
     */
    @Column(name="expert_name")
    private String expertName;

    /**
     * 出生日期
     */
    @Column(name="birthday")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    /**
     * 0男1女
     */
    @Column(name="gender")
    private Byte gender;

    /**
     * 民族
     */
    @Column(name="nation")
    private String nation;

    /**
     * 0在职1离职
     */
    @Column(name="job_status")
    private Byte jobStatus;

    /**
     * 固定电话
     */
    @Column(name="fixed_phone")
    private String fixedPhone;

    /**
     * 专家类型(0:采矿专业1:机电专业2:通风安全专业3:地质专业4:通信与自动化专业
     *          5:财务专业6:测量专业7:爆破专业8:煤炭洗选9:其它)
     */
    @Column(name="expert_type")
    private Byte expertType;

    /**
     * 适用事件
     */
    @Column(name="applicable_events")
    private String applicableEvents;

    /**
     * 移动电话
     */
    @Column(name="phone")
    private String phone;

    /**
     * 地址
     */
    @Column(name="address")
    private String address;

    /**
     * 工作单位
     */
    @Column(name="employer")
    private String employer;

    /**
     * 单位地址
     */
    @Column(name="employer_address")
    private String employerAddress;

    /**
     * 经度
     */
    @Column(name="longitude")
    private Long longitude;

    /**
     * 纬度
     */
    @Column(name="latitude")
    private Long latitude;

    /**
     * 0删除1未删除
     */
    @Column(name="is_del")
    private Byte isDel;

    /**
     * 创建时间
     */
    @Column(name="create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    @Column(name="update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private java.util.Date updateTime;

    /**
     * 事故处理经历
     */
    @Column(name="experience")
    private String experience;

    private static final long serialVersionUID = 1L;

}