package org.yh.shop.dao;

import org.yh.shop.model.PropValue;

import java.util.List;

public interface PropValueDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PropValue record);

    int insertSelective(PropValue record);

    PropValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PropValue record);

    int updateByPrimaryKey(PropValue record);

    List<PropValue> selectByPIds(Long id);
}