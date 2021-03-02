package org.yh.shop.dao;

import org.apache.ibatis.annotations.Param;
import org.yh.shop.model.Basket;
import org.yh.shop.model.vo.BasketVo;

import java.util.List;

public interface BasketDao {
    int deleteByPrimaryKey(Integer basketId);

    int insert(Basket record);

    int insertSelective(Basket record);

    Basket selectByPrimaryKey(Integer basketId);

    int updateByPrimaryKeySelective(Basket record);

    int updateByPrimaryKey(Basket record);

    List<BasketVo> findBasketById(Integer userId);

    long update(@Param("basketId") Integer basketId,@Param("num") Integer num);

    long deleteByIds(Integer[] basketIds);
}