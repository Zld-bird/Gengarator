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
@Table(name = "tb_corp_base_info")
public class TbCorpBaseInfo implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name="id")
    private Integer id;

    /**
     * 企业名称
     */
    @Column(name="corp_name")
    private String corpName;

    /**
     * 煤矿编号
     */
    @Column(name="coalmine_number")
    private String coalmineNumber;

    /**
     * 企业别名
     */
    @Column(name="corp_other_name")
    private String corpOtherName;

    /**
     * 开采类别
     */
    @Column(name="mine_type")
    private String mineType;

    /**
     * 生产建设状态
     */
    @Column(name="build_state")
    private String buildState;

    /**
     * 统一社会信用代码
     */
    @Column(name="explosive_description")
    private String explosiveDescription;

    /**
     * 煤矿类型1:国有重点2:国有地方3:非国有煤矿
     */
    @Column(name="corp_type")
    private Integer corpType;

    /**
     * 煤矿编码
     */
    @Column(name="coalmine_code")
    private String coalmineCode;

    /**
     * 许可证状态
     */
    @Column(name="licence_state")
    private Integer licenceState;

    /**
     * 法定代表人
     */
    @Column(name="chargeman")
    private String chargeman;

    /**
     * 法定代表人电话
     */
    @Column(name="chargeman_phone")
    private String chargemanPhone;

    /**
     * 邮政编码
     */
    @Column(name="post_code")
    private String postCode;

    /**
     * 联系人
     */
    @Column(name="contacts")
    private String contacts;

    /**
     * 联系人电话
     */
    @Column(name="contacts_phone")
    private String contactsPhone;

    /**
     * 电子邮箱
     */
    @Column(name="email")
    private String email;

    /**
     * 调度室电话
     */
    @Column(name="dispatch_phone")
    private String dispatchPhone;

    /**
     * 主管政府部门级别
     */
    @Column(name="management_level")
    private String managementLevel;

    /**
     * 开采工艺1:间断开采2:连续开采3:半连续开采4:综合开采
     */
    @Column(name="mini_technology")
    private String miniTechnology;

    /**
     * 煤矿地址
     */
    @Column(name="address")
    private String address;

    /**
     * 上级企业id
     */
    @Column(name="top_corp_id")
    private Integer topCorpId;

    /**
     * 上级企业名称
     */
    @Column(name="top_corp_name")
    private String topCorpName;

    /**
     * 企业经济类型
     */
    @Column(name="economic_type_name")
    private String economicTypeName;

    /**
     * 标准化等级1:一级2:二级3:三级4:不合格5:未评定
     */
    @Column(name="standard_grade")
    private String standardGrade;

    /**
     * 矿井井型
     */
    @Column(name="mine_class")
    private Integer mineClass;

    /**
     * 矿井井型名称
     */
    @Column(name="mine_class_name")
    private String mineClassName;

    /**
     * 经度-gis使用
     */
    @Column(name="longitude")
    private String longitude;

    /**
     * 东经-度
     */
    @Column(name="longitude_d")
    private Integer longitudeD;

    /**
     * 东经-分
     */
    @Column(name="longitude_f")
    private Integer longitudeF;

    /**
     * 东经-秒
     */
    @Column(name="longitude_m")
    private Integer longitudeM;

    /**
     * 纬度-gis使用
     */
    @Column(name="latitude")
    private String latitude;

    /**
     * 北纬-度
     */
    @Column(name="latitude_d")
    private Integer latitudeD;

    /**
     * 北纬-分
     */
    @Column(name="latitude_f")
    private Integer latitudeF;

    /**
     * 北纬-秒
     */
    @Column(name="latitude_m")
    private Integer latitudeM;

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
     * 删除标识(0:删除，1:保留)
     */
    @Column(name="is_delete")
    private Byte isDelete;

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