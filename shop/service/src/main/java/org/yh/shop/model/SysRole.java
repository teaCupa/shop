package org.yh.shop.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_role
 * @author 
 */
@Data
public class SysRole implements Serializable {
    private Integer id;

    private String roleName;

    private String roleNickname;

    private Byte status;

    private Date createBy;

    private static final long serialVersionUID = 1L;
}