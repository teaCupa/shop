package org.yh.shop.service;

import org.yh.shop.model.SysUser;

import java.util.Set;

/**
 * @Author: yh
 * @Date: 2020/12/23
 * @Description:
 */


public interface SysUserService {
    /*根据用户名查找菜单的权限字段*/
    Set<String> findPermissions(String username);

    SysUser loadUserByUsername(String s);

    SysUser findByName(String name);
}
