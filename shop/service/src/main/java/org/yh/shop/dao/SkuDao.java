package org.yh.shop.dao;

import org.apache.ibatis.annotations.Param;
import org.yh.shop.model.Sku;
import org.yh.shop.model.vo.SpuSkuRelVo;

import java.util.List;

public interface SkuDao {
    int deleteByPrimaryKey(Integer skuId);

    int insert(Sku record);

    int insertSelective(Sku record);

    Sku selectByPrimaryKey(Integer skuId);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);

    List<SpuSkuRelVo> selectByPropSpuId(@Param("spuId") Integer id);
}