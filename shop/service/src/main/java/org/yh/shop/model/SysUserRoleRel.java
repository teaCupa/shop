package org.yh.shop.model;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_user_role_rel
 * @author 
 */
@Data
public class SysUserRoleRel implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private Boolean status;

    private static final long serialVersionUID = 1L;
}