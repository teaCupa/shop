package org.yh.shop.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_user
 * @author 
 */
@Data
public class SysUser implements Serializable {
    private Integer id;

    private String name;

    private String nickname;

    private String password;

    /**
     * 头像
     */
    private String pic;

    private Date createBy;

    private Date updateBy;

    private Byte enabled;

    private static final long serialVersionUID = 1L;
}