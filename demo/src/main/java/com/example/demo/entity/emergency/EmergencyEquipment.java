package com.example.demo.entity.emergency;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 应急装备
 */
@Entity
@Data
@Table(name = "emergency_equipment")
public class EmergencyEquipment implements Serializable {
    /**
     * 主键
     */
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 装备名称
     */
    @Column(name="equipment_name")
    private String equipmentName;

    /**
     * 所属企业
     */
    @Column(name="parent_corp")
    private String parentCorp;

    /**
     * 装备类型(1:工程设备类2:危化救援类3:地震救援类4:矿山救援类5:消防器材类6:水上救援类7:医疗救护类8:交通运输类9:通讯类10:应急器具类11:环境监测类12:气象监测类13:其他类型)
     */
    @Column(name="equipment_type")
    private Byte equipmentType;

    /**
     * 规格
     */
    @Column(name="specification")
    private String specification;

    /**
     * 型号
     */
    @Column(name="model")
    private String model;

    /**
     * 计量单位
     */
    @Column(name="unit")
    private String unit;

    /**
     * 用途
     */
    @Column(name="use_on")
    private String useOn;

    /**
     * 性能
     */
    @Column(name="performance")
    private String performance;

    /**
     * 单价
     */
    @Column(name="price")
    private BigDecimal price;

    /**
     * 出场日期
     */
    @Column(name="factory_date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date factoryDate;

    /**
     * 购买日期
     */
    @Column(name="buy_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date buyDate;

    /**
     * 生产厂家
     */
    @Column(name="factory")
    private String factory;

    /**
     * 使用年限
     */
    @Column(name="use_year")
    private Double useYear;

    /**
     * 经度
     */
    @Column(name="longitude")
    private BigDecimal longitude;

    /**
     * 纬度
     */
    @Column(name="latitude")
    private BigDecimal latitude;

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
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name="update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 装备数量
     */
    @Column(name="numbers")
    private String numbers;

    private static final long serialVersionUID = 1L;

}