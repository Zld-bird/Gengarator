package com.example.demo.entity.emergency;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author zld
 * date: 2020/9/24
 * version: 02.06
 */
@Data
public class EmergencyOrganizationVo {

    /**
     * 机构id
     */
    private Long orgId;
    /**
     * 中间表id
     */
    private Long orgMemberIdS;
    private Long orgMemberIdC;
    /**
     * 成员id
     */
    private Long sLeaderId;
    private Long cLeaderId;

    /**
     * 应急机构名称
     */
    private String organizationName;

    /**
     * 主管领导名称
     */
    private String supervisorName;

    /**
     * 主管手机
     */
    private String supervisorPhone;

    /**
     * 分管领导姓名
     */
    private String chargeLeaderName;
    /**
     * 分管领导手机
     */
    private String chargeLeaderPhone;

    /**
     * 值班传真
     */
    private String dutyFax;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 值班电话
     */
    private String dutyTelephone;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT+8")
    private Date updateTime;

    /**
     * 负责人
     */
    private String chargeMan;
    /**
     * 职务(0:主管领导，1:分管领导)
     */
    private String position;

    /**
     * 领导电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 成立日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private String establishDate;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 删除标识
     */
    private Integer isDel;

    private Long eomId;
}
