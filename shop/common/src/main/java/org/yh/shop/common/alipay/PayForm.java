package org.yh.shop.common.alipay;

import lombok.Data;

/**
 * @Author: yh
 * @Date: 2020/12/5
 * @Description:  遵循接口指定的参数
 */

@Data
public class PayForm {
    /**
     * 商户订单号，必填
     *
     */
    private String out_trade_no;
    /**
     * 订单名称，必填
     */
    private String subject;
    /**
     * 付款金额，必填
     * 根据支付宝接口协议，必须使用下划线
     */
    private Float total_amount;
    /**
     * 商品描述，可空
     */
    private String body;

    /**
     * 产品编号
     */
    private String product_code= "FAST_INSTANT_TRADE_PAY";
}
