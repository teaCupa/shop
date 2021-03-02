package org.yh.shop.dao;

import org.yh.shop.model.SysMenu;

import java.util.List;

public interface SysMenuDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> findByName(String username);

    List<SysMenu> findAll();
}