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
@Table(name = "tb_coalmine_picture")
public class TbCoalminePicture implements Serializable {
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