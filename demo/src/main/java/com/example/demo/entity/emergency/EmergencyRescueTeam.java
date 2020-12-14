package com.example.demo.entity.emergency;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 应急救援队伍
 */
@Data
@Table(name = "emergency_rescue_team")
@Entity
public class EmergencyRescueTeam {

    /**
     * 主键，自增
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 应急队伍名称
     */
    @Column(name = "team_name")
    private String teamName;

    /**
     * 所属企业
     */
    @Column(name = "parent_unit")
    private String parentUnit;

    /**
     * 应急队伍数量
     */
    @Column(name = "team_number")
    private Integer teamNumber;

    /**
     * 应急队伍类型队伍类型(0:医疗队伍1:消防队伍2:部队预备役队伍3:矿山救援队伍4:非煤矿山救援队伍
     *                      5:煤矿救援队伍6:综合救援队伍7:危化救援队伍8:其他救援队伍)
     */
    @Column(name = "team_type")
    private Byte teamType;

    /**
     * 负责人
     */
    @Column(name = "charge_man")
    private String chargeMan;

    /**
     * 负责人手机
     */
    @Column(name = "charge_phone")
    private String chargePhone;

    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 值班电话
     */
    @Column(name = "duty_phone")
    private String dutyPhone;

    /**
     * 传真
     */
    @Column(name = "fax")
    private String fax;

    /**
     * 值班传真
     */
    @Column(name = "duty_fax")
    private String dutyFax;

    /**
     * 车辆数量
     */
    @Column(name = "car_number")
    private Integer carNumber;

    /**
     * 擅长事故类型
     */
    @Column(name = "good_type")
    private String goodType;

    /**
     * 主要装备描述
     */
    @Column(name = "equipment_description")
    private String equipmentDescription;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 成立日期
     */
    @Column(name = "establish_date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date establishDate;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 经度
     */
    @Column(name = "longitude")
    private Long longitude;

    /**
     * 纬度
     */
    @Column(name = "latitude")
    private Long latitude;

    /**
     * 0删除 1未删除
     */
    @Column(name = "is_del")
    private Byte isDel;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}