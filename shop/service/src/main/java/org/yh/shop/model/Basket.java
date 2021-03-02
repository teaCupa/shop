package org.yh.shop.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * basket
 * @author 
 */
@Data
public class Basket implements Serializable {
    /**
     * 购物车主键
     */
    private Integer basketId;

    private Integer userId;

    private Integer skuId;

    private Integer num;

    private Integer shopId;

    private Byte status;

    private Date updateDate;

    private static final long serialVersionUID = 1L;
}