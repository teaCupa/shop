package org.yh.shop.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * sys_menu
 * @author 
 */
@Data
public class SysMenu implements Serializable {
    private Integer id;

    private String name;

    private Integer parentId;

    private String url;

    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Byte type;

    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    private Date createAt;

    private Date updateAt;

    private Boolean status;

    // 非数据库字段
    private String parentName;
    // 非数据库字段
    private Integer level;
    // 非数据库字段
    private List<SysMenu> children;

    private static final long serialVersionUID = 1L;
}