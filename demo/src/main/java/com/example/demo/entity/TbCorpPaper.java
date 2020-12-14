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
@Table(name = "tb_corp_paper")
public class TbCorpPaper implements Serializable {
    /**
     * 证照id(证照id)
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
     * 版本(版本)
     */
    @Column(name="version")
    private Integer version;

    /**
     * 颁证机构
     */
    @Column(name="agency")
    private String agency;

    /**
     * 颁证时间
     */
    @Column(name="award_date")
    private String awardDate;

    /**
     * 附件标识
     */
    @Column(name="catalogid")
    private String catalogid;

    /**
     * 企业id(企业id)
     */
    @Column(name="corp_id")
    private Integer corpId;

    /**
     * 失效时间
     */
    @Column(name="end_date")
    private String endDate;

    /**
     * 排序
     */
    @Column(name="renk_no")
    private String renkNo;

    /**
     * 证件类型
     */
    @Column(name="type")
    private String type;

    /**
     * 工作日期
     */
    @Column(name="work_date")
    private String workDate;

    /**
     * 证件号
     */
    @Column(name="card_number")
    private String cardNumber;

    /**
     * 照片路径
     */
    @Column(name="path")
    private String path;

    /**
     * 照片名称
     */
    @Column(name="file_name")
    private String fileName;

    /**
     * 添加时间
     */
    @Column(name="add_time")
    private Date addTime;

    /**
     * 添加人id(添加人id)
     */
    @Column(name="add_user_id")
    private Integer addUserId;

    /**
     * 添加人名字
     */
    @Column(name="add_user_name")
    private String addUserName;

    /**
     * 是否删除
     */
    @Column(name="is_delete")
    private String isDelete;

    /**
     * 登录类型
     */
    @Column(name="login_type")
    private String loginType;

    /**
     * 修改时间
     */
    @Column(name="update_time")
    private Date updateTime;

    /**
     * 修改人id(修改人id)
     */
    @Column(name="up_user_id")
    private Integer upUserId;

    /**
     * 修改人姓名
     */
    @Column(name="up_user_name")
    private String upUserName;

    private static final long serialVersionUID = 1L;

 }