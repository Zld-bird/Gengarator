package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "tb_coal_wellbore_info")
public class TbCoalWellboreInfo implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name="id")
    private Integer id;

    /**
     * 井筒名称
     */
    @Column(name="wellbore_name")
    private String wellboreName;

    /**
     * 煤矿编号
     */
    @Column(name="coalmine_number")
    private String coalmineNumber;

    /**
     * 垂深（长度）（米）
     */
    @Column(name="vertical_depth")
    private String verticalDepth;

    /**
     * 断面积（平米）
     */
    @Column(name="section_area")
    private String sectionArea;

    /**
     * 井筒坐标X
     */
    @Column(name="wellbore_coordinateX")
    private BigDecimal wellboreCoordinatex;

    /**
     * 井筒坐标Y
     */
    @Column(name="wellbore_coordinateY")
    private BigDecimal wellboreCoordinatey;

    /**
     * 井筒坐标Z
     */
    @Column(name="wellbore_coordinateZ")
    private BigDecimal wellboreCoordinatez;

    /**
     * 角度
     */
    @Column(name="angle")
    private String angle;

    /**
     * 支护方式
     */
    @Column(name="support_method")
    private String supportMethod;

    /**
     * 提升机型号
     */
    @Column(name="hoist_model")
    private String hoistModel;

    /**
     * 井筒类型
     */
    @Column(name="wellbore_type")
    private String wellboreType;

    /**
     * 是否删除(0/删除,1/不删除)
     */
    @Column(name="is_delete")
    private Byte isDelete;

    /**
     * 新增时间
     */
    @JsonFormat(timezone = "yyyy-mm-dd HH:mm:ss")
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
    @JsonFormat(timezone = "yyyy-mm-dd HH:mm:ss")
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