package org.yh.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * sku
 * @author 
 */
@Data
public class Sku implements Serializable {
    private Integer skuId;

    /**
     * 属性描述
     */
    private String skuProperties;

    private String skuName;

    private String skuPic;

    private BigDecimal skuPrice;

    /**
     * 库存
     */
    private String skuStock;

    private Integer skuSaleNum;

    private Integer shopId;

    private Byte status;

    private Date createDate;

    private Date updateDate;

    private Integer version;

    private static final long serialVersionUID = 1L;
}