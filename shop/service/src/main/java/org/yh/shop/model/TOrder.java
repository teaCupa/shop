package org.yh.shop.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * t_order
 * @author
 *    表名order与mysql的order表冲突
 */
@Data
public class TOrder implements Serializable {
    private Integer orderId;

    private Integer shopId;

    private String orderName;

    /**
     * 订单编号
     */
    private String orderNumber;

    private Integer userId;

    private BigDecimal totalPrice;

    /**
     * 实际支付
     */
    private BigDecimal actualPrice;

    /**
     * 购买数量
     */
    private Integer productNum;

    private String orderDesc;

    /**
     * 支付类型 1 支付宝  ； 2微信支付
     */
    private Integer payType;

    /**
     * 0 未付款 ；1已付款
     */
    private Integer status;

    private String address;

    private Date createDate;

    private Date updateDate;

    private static final long serialVersionUID = 1L;
}