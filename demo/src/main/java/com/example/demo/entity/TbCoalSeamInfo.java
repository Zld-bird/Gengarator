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
@Table(name = "tb_coal_seam_info")
public class TbCoalSeamInfo implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name="id")
    private Long id;

    /**
     * 煤矿编号
     */
    @Column(name="coalmine_number")
    private String coalmineNumber;

    /**
     * 煤层名称
     */
    @Column(name="coal_seam_name")
    private String coalSeamName;

    /**
     * 主要煤种
     */
    @Column(name="coal_type")
    private String coalType;

    /**
     * 地质储量
     */
    @Column(name="reserve")
    private Double reserve;

    /**
     * 可采储量
     */
    @Column(name="recoverable_reserves")
    private Double recoverableReserves;

    /**
     * 煤层平均厚度
     */
    @Column(name="coal_seam_avg_thickness")
    private Float coalSeamAvgThickness;

    /**
     * 煤层最大厚度
     */
    @Column(name="coal_seam_max_thickness")
    private Float coalSeamMaxThickness;

    /**
     * 删除标志(0:删除，1:保留)
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