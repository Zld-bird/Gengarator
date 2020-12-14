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
@Table(name = "tb_corp_person")
public class TbCorpPerson implements Serializable {
    /**
     * 主键id
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
     * 版本号
     */
    @Column(name="version")
    private Integer version;

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
     * 企业id
     */
    @Column(name="corp_id")
    private Integer corpId;

    /**
     * 用户职称字典id
     */
    @Column(name="duty")
    private String duty;

    /**
     * 教育程度字典id
     */
    @Column(name="education")
    private Integer education;

    /**
     * 人员名称
     */
    @Column(name="name")
    private String name;

    /**
     * 安全证编号
     */
    @Column(name="cafe_cer_no")
    private String cafeCerNo;

    /**
     * 性别
     */
    @Column(name="sex")
    private String sex;

    /**
     * 电话号
     */
    @Column(name="telephone")
    private String telephone;

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
    @Column(name="add_user_name")
    private String addUserName;

    /**
     * 是否删除标志
     */
    @Column(name="is_delete")
    private String isDelete;

    /**
     * 登录种类标志
     */
    @Column(name="login_type")
    private String loginType;

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
     * 更新用户名称
     */
    @Column(name="up_user_name")
    private String upUserName;

    private static final long serialVersionUID = 1L;

 }