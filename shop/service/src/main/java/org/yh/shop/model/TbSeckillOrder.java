package org.yh.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * tb_seckill_order
 * @author 
 */
@Data
public class TbSeckillOrder implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 秒杀商品ID
     */
    private Long seckillId;

    /**
     * 支付金额
     */
    private BigDecimal money;

    /**
     * 用户
     */
    private String userId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date createTime;

    /**
     * 支付时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date payTime;

    /**
     * 状态，0未支付，1已支付
     */
    private String status;

    /**
     * 收货人地址
     */
    private String receiverAddress;

    /**
     * 收货人电话
     */
    private String receiverMobile;

    /**
     * 收货人
     */
    private String receiver;

    /**
     * 交易流水
     */
    private String transactionId;

    private static final long serialVersionUID = 1L;
}