package com.example.demo.entity.emergency;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zld
 * date: 2020/9/29
 * version: 02.06
 */
@Entity
@Data
@Table(name = "emergency_plan")
public class EmergencyPlan implements Serializable {
    private static final long serializableUID = 1L;

    /**
     * 主键，自动递增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 预案名称
     */
    @Column(name = "plan_name")
    private String planName;

    /**
     * 所属企业
     */
    @Column(name = "parent_corp")
    private String parentCorp;

    /**
     * 预案编号
     */
    @Column(name = "plan_code")
    private String planCode;

    /**
     * 预案类型0:专项预案1:综合预案2:现场处置预案
     */
    @Column(name = "plan_type")
    private Integer planType;

    /**
     *  预案状态0：未上报1：审核通过2：打回
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 0删除1未删除
     */
    @Column(name = "is_del")
    private Byte isDel;

    /**
     * 发布日期
     */
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "publish_date")
    private Date publishDate;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
}
