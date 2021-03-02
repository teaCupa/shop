package org.yh.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yh.shop.dao.SysUserDao;
import org.yh.shop.model.SysMenu;
import org.yh.shop.model.SysUser;
import org.yh.shop.service.SysMenuService;
import org.yh.shop.service.SysUserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: yh
 * @Date: 2020/12/23
 * @Description:
 */

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public Set<String> findPermissions(String username) {
        Set<String>perms=new HashSet<>();
        List<SysMenu> sysMenus =sysMenuService.findByName(username);
        for (SysMenu sysMenu : sysMenus) {
            if(sysMenu.getPerms() !=null && !"".equals(sysMenu.getPerms())){
                perms.add(sysMenu.getPerms());
            }
        }
        return perms;
    }

    @Override
    public SysUser loadUserByUsername(String name) {
        return sysUserDao.findUserByName(name);
    }

    @Override
    public SysUser findByName(String name) {
        return sysUserDao.findByName(name);
    }

}
