package org.yh.shop.dao;

import org.yh.shop.model.TbSeckillGoods;

import java.util.Date;
import java.util.List;

public interface TbSeckillGoodsDao {
    int deleteByPrimaryKey(Long id);

    int insert(TbSeckillGoods record);

    int insertSelective(TbSeckillGoods record);

    TbSeckillGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbSeckillGoods record);

    int updateByPrimaryKey(TbSeckillGoods record);

    List<TbSeckillGoods> findAll(Date date);
}