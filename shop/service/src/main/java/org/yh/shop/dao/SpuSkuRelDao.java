package org.yh.shop.dao;

import org.yh.shop.model.SpuSkuRel;

public interface SpuSkuRelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SpuSkuRel record);

    int insertSelective(SpuSkuRel record);

    SpuSkuRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpuSkuRel record);

    int updateByPrimaryKey(SpuSkuRel record);
}