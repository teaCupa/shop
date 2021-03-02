package org.yh.shop.model.vo;

import lombok.Data;

/**
 * @Author: yh
 * @Date: 2020/11/30
 * @Description:
 */

@Data
public class CartVo {
    private String userId;
    private String skuId;
    private String spuId;  //秒杀专属字段，普通订单没有
    private String secKillChannel;  //秒杀专属字段，普通订单没有
}
