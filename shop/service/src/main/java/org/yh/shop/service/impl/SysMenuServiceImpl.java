package org.yh.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yh.shop.dao.SysMenuDao;
import org.yh.shop.model.SysMenu;
import org.yh.shop.service.SysMenuService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/12/23
 * @Description:
 */

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public List<SysMenu> findTree(String username, int menuType) {
        List<SysMenu> sysMenus = new ArrayList<>();
        List<SysMenu> menus = findByName(username);
        for (SysMenu menu : menus) {
            if (menu.getParentId() == null || menu.getParentId() == 0) {
                menu.setLevel(0);    //顶级菜单
                if (!exists(sysMenus, menu)) { //防止重复添加
                    sysMenus.add(menu);
                }
            }
        }
        sysMenus.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
        findChildren(sysMenus, menus, menuType);
        return sysMenus;
    }

    @Override
    public List<SysMenu> findByName(String username) {
        if (username == null || "admin".equals(username))
            return sysMenuDao.findAll();
        return sysMenuDao.findByName(username);
    }

    @Override
    public int delete(List<SysMenu> records) {
        for (SysMenu record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public int delete(SysMenu record) {
        return sysMenuDao.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int save(SysMenu record) {
        if(record.getId() == null || record.getId() == 0) {
            return sysMenuDao.insertSelective(record);
        }
        if(record.getParentId() == null) {
            record.setParentId(0);
        }
        return sysMenuDao.updateByPrimaryKeySelective(record);
    }

    /**
     * findChidren方法是一个递归查询操作,递归出口SysMenus==NULL
     *
     * @param SysMenus 父级别菜单
     * @param menus    当前用户查询到的所有菜单
     * @param menuType 标识变量，判断是否查询按钮操作菜单
     */
    private void findChildren(List<SysMenu> SysMenus, List<SysMenu> menus, int menuType) {
        for (SysMenu SysMenu : SysMenus) {
            List<SysMenu> children = new ArrayList<>();
            for (SysMenu menu : menus) {
                //menuType==0  不包含按钮  menuType==1 包含按钮
                if (menuType == 0 && menu.getType() == 2) {
                    continue;
                }
                if (SysMenu.getId() != null && SysMenu.getId().equals(menu.getParentId())) {
                    //找到父菜单的子菜单
                    menu.setParentName(SysMenu.getName());
                    menu.setLevel(SysMenu.getLevel() + 1);
                    if (!exists(children, menu)) {
                        children.add(menu);
                    }
                }
            }
            SysMenu.setChildren(children);
            children.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
            findChildren(children, menus, menuType);
        }
    }

    private boolean exists(List<SysMenu> sysMenus, SysMenu sysMenu) {
        for (SysMenu menu : sysMenus) {
            if (menu.getId().equals(sysMenu.getId())) {
                return true;
            }
        }
        return false;
    }
}
