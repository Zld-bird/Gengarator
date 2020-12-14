package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "tb_safe_avoidance")
public class TbSafeAvoidance implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name="id")
    private Integer id;

    /**
     * 煤矿编号
     */
    @Column(name="coalmine_number")
    private String coalmineNumber;

    /**
     * 系统名称
     */
    @Column(name="system_name")
    private String systemName;

    /**
     * 简单描述
     */
    @Column(name="quick_description")
    private String quickDescription;

    /**
     * 状态
     */
    @Column(name="status")
    private Byte status;

    /**
     * 系统类型
     */
    @Column(name="system_type")
    private Byte systemType;

    /**
     * 删除标识（0:删除，1:保留）
     */
    @Column(name="is_delete")
    private Byte isDelete;

    /**
     * 新增时间
     */
    @Column(name="add_time")
    private Date addTime;

    /**
     * 新增用户id
     */
    @Column(name="add_user_id")
    private Integer addUserId;

    /**
     * 新增用户名称
     */
    @Column(name="add_username")
    private String addUsername;

    /**
     * 更新时间
     */
    @Column(name="update_time")
    private Date updateTime;

    /**
     * 更新用户id
     */
    @Column(name="up_user_id")
    private Integer upUserId;

    /**
     * 更新用户名
     */
    @Column(name="update_username")
    private String updateUsername;

    private static final long serialVersionUID = 1L;

}