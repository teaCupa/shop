package org.yh.shop.model.vo;

import lombok.Data;
import org.yh.shop.model.Basket;
import org.yh.shop.model.Sku;

import java.io.Serializable;

/**
 * @Author: yh
 * @Date: 2020/12/7
 * @Description:
 */

@Data
public class BasketVo extends Basket implements Serializable {
    private Sku sku;
}
