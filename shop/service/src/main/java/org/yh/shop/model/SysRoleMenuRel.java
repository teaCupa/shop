package org.yh.shop.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_role_menu_rel
 * @author 
 */
@Data
public class SysRoleMenuRel implements Serializable {
    private Integer id;

    private Integer roleId;

    private Integer menuId;

    private Date createAt;

    private Date updateAt;

    private static final long serialVersionUID = 1L;
}