package org.yh.shop.dao;

import org.yh.shop.model.PropName;
import org.yh.shop.model.vo.PropNameVo;

import java.util.List;

public interface PropNameDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PropName record);

    int insertSelective(PropName record);

    PropName selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PropName record);

    int updateByPrimaryKey(PropName record);

    List<PropName> selectByPIds(Long id);

    List<PropNameVo> findAll();
}