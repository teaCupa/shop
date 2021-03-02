package org.yh.shop.dao;

import org.yh.shop.model.SysUserRoleRel;

public interface SysUserRoleRelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRoleRel record);

    int insertSelective(SysUserRoleRel record);

    SysUserRoleRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRoleRel record);

    int updateByPrimaryKey(SysUserRoleRel record);
}