package org.yh.shop.dao;

import org.yh.shop.model.TbSeckillOrder;

public interface TbSeckillOrderDao {
    int deleteByPrimaryKey(Long id);

    int insert(TbSeckillOrder record);

    int insertSelective(TbSeckillOrder record);

    TbSeckillOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbSeckillOrder record);

    int updateByPrimaryKey(TbSeckillOrder record);

    TbSeckillOrder selectOne(String orderTrancId);
}