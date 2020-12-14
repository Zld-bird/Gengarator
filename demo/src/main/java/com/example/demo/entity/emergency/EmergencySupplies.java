package com.example.demo.entity.emergency;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "emergency_supplies")
public class EmergencySupplies implements Serializable {
    /**
     * 主键
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    private Long id;

    /**
     * 储备库名称
     */
    @Column(name="reserve_name")
    private String reserveName;

    /**
     * 所属企业
     */
    @Column(name="parent_corp")
    private String parentCorp;

    /**
     * 储备库类型0:交通运输1:灭火装备2:装备工具3:其他4:防护用品5:生命救助
     *           6:急救医药7:临时食宿8:污染清理9:动力燃烧10:检测仪器11:通讯广播
     */
    @Column(name="reserve_type")
    private Byte reserveType;

    /**
     * 主要物资
     */
    @Column(name="main_materials")
    private String mainMaterials;

    /**
     * 物资类型0:灭火装备
     */
    @Column(name="materials_type")
    private Byte materialsType;

    /**
     * 负责人
     */
    @Column(name="charge_man")
    private String chargeMan;

    /**
     * 负责人电话
     */
    @Column(name="charge_phone")
    private String chargePhone;

    /**
     * 储备量
     */
    @Column(name="reserve")
    private Integer reserve;

    /**
     * 值班电话
     */
    @Column(name="duty_phone")
    private String dutyPhone;

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
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name="update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

}