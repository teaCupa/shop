package org.yh.shop.service;

import org.yh.shop.model.SysMenu;

import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/12/23
 * @Description:
 */


public interface SysMenuService {

    /**
     * 查询菜单树
     * @param menuType 获取菜单类型，1：获取所有菜单，包含按钮，
     *                  0：获取所有菜单，不包含按钮
     * @param userName
     * @return
     */
    List<SysMenu> findTree(String userName, int menuType);

    List<SysMenu> findByName(String username);

    int delete(List<SysMenu> records);

    int delete(SysMenu record);

    int save(SysMenu record);
}
