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
@Table(name = "tb_coal_cutting_work_face")
public class TbCoalCuttingWorkFace implements Serializable {
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
     * 工作面名称
     */
    @Column(name="work_face_name")
    private String workFaceName;

    /**
     * 煤层信息id
     */
    @Column(name="coal_seam_id")
    private Long coalSeamId;

    /**
     * 开采煤层
     */
    @Column(name="mining_coal_seam")
    private String miningCoalSeam;

    /**
     * 采煤工艺
     */
    @Column(name="coalmine_craft")
    private String coalmineCraft;

    /**
     * 巷道支护方式
     */
    @Column(name="roadway_support_method")
    private String roadwaySupportMethod;

    /**
     * 台阶高度
     */
    @Column(name="step_height")
    private Float stepHeight;

    /**
     * 采掘带宽度
     */
    @Column(name="mine_belt_width")
    private Float mineBeltWidth;

    /**
     * 出入沟宽度
     */
    @Column(name="access_ditch_width")
    private Float accessDitchWidth;

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