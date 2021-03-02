package org.yh.shop.dao;

import org.yh.shop.model.SysRoleMenuRel;

public interface SysRoleMenuRelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleMenuRel record);

    int insertSelective(SysRoleMenuRel record);

    SysRoleMenuRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleMenuRel record);

    int updateByPrimaryKey(SysRoleMenuRel record);
}