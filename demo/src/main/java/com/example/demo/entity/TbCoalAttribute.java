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
@Table(name = "tb_coal_attribute")
public class TbCoalAttribute implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name="id")
    private Integer id;

    /**
     * 煤矿编号
     */
    @Column(name="coalmine_code")
    private String coalmineCode;

    /**
     * 核定生产能力
     */
    @Column(name="proved_output")
    private String provedOutput;

    /**
     * 投产日期字符串
     */
    @Column(name="product_date")
    private Date productDate;

    /**
     * 建设时间
     */
    @Column(name="build_time")
    private Date buildTime;

    /**
     * 开拓方式
     */
    @Column(name="mine_style")
    private String mineStyle;

    /**
     * 开采工艺1:间断开采2:连续开采3:半连续开采4:综合开采
     */
    @Column(name="mini_technology")
    private String miniTechnology;

    /**
     * 允许开采上下标高
     */
    @Column(name="level_high")
    private String levelHigh;

    /**
     * 矿井地质类型id
     */
    @Column(name="geo_type")
    private String geoType;

    /**
     * 允许开采深度
     */
    @Column(name="approved_mine_depth")
    private String approvedMineDepth;

    /**
     * 是否有冲击地压1:无2:有
     */
    @Column(name="rock_burst")
    private Byte rockBurst;

    /**
     * 主要灾害类型1:自燃2:水害3:爆炸4:瓦斯5:冲击地压
     */
    @Column(name="geohazard_type")
    private String geohazardType;

    /**
     * 煤层爆炸性1:有爆炸性2:无爆炸性3:未检测
     */
    @Column(name="grime_explosive")
    private String grimeExplosive;

    /**
     * 瓦斯等级1:瓦斯矿井2:高瓦斯矿井3:突出矿井4:待定
     */
    @Column(name="ws_grade")
    private String wsGrade;

    /**
     * 水文地质类型1:简单2:中等3:复杂4:极复杂
     */
    @Column(name="hydrogeological_type")
    private String hydrogeologicalType;

    /**
     * 最大涌水量
     */
    @Column(name="water_burst_max")
    private String waterBurstMax;

    /**
     * 是否建立边坡稳定性监测系统1:是2:否
     */
    @Column(name="is_build_monitor")
    private Byte isBuildMonitor;

    /**
     * 排水方式
     */
    @Column(name="drainage_way")
    private String drainageWay;

    /**
     * 是否产能置换新建煤矿
     */
    @Column(name="is_replace_new_mine")
    private Byte isReplaceNewMine;

    /**
     * 是否产能置换被替换
     */
    @Column(name="is_replace_replaced_mine")
    private Byte isReplaceReplacedMine;

    /**
     * 是否计划退出煤矿
     */
    @Column(name="is_plan_exit_mine")
    private Byte isPlanExitMine;

    /**
     * 运输方式1:皮带运输2:电机车牵引3:调度绞车4:人力绞车5:人力手推矿车6:其他
     */
    @Column(name="trans_type")
    private String transType;

    /**
     * 运输方式描述
     */
    @Column(name="trans_description")
    private String transDescription;

    /**
     * 供电方式1:双回路2:双电源3:单回路
     */
    @Column(name="power_style")
    private String powerStyle;

    /**
     * 供电方式描述
     */
    @Column(name="power_description")
    private String powerDescription;

    /**
     * 通风方式
     */
    @Column(name="ventilate_style")
    private String ventilateStyle;

    /**
     * 通风方式描述
     */
    @Column(name="ventilate_description")
    private String ventilateDescription;

    /**
     * 煤层自燃倾向性
     */
    @Column(name="coal_fire")
    private String coalFire;

    /**
     * 煤层自燃倾向性说明
     */
    @Column(name="fire_description")
    private String fireDescription;

    /**
     * 交通情况
     */
    @Column(name="traffic_condition")
    private String trafficCondition;

    /**
     * 煤层顶底板岩性
     */
    @Column(name="rf_lithology")
    private String rfLithology;

    /**
     * 相邻矿井
     */
    @Column(name="neigh_mine")
    private String neighMine;

    /**
     * 井田范围
     */
    @Column(name="mine_range")
    private String mineRange;

    /**
     * 井田面积
     */
    @Column(name="mine_area")
    private String mineArea;

    /**
     * 地质概况
     */
    @Column(name="geo_overview")
    private String geoOverview;

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