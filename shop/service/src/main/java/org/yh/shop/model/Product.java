package org.yh.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * product
 * @author 
 */
@Data
public class Product implements Serializable {
    /**
     * 产品id
     */
    private Long id;

    private String name;

    /**
     * 商家id
     */
    private String shopId;

    /**
     * 商品主图
     */
    private String pic;

    /**
     * 商品图片，以,分割
     */
    private String imgs;

    private BigDecimal price;

    private Boolean status;

    /**
     * 简介
     */
    private String brief;

    /**
     * 种类
     */
    private Integer categoryId;

    /**
     * 销量
     */
    private Integer saleNum;

    /**
     * 库存数量
     */
    private Integer stockNum;

    /**
     *  排序
     */
    private Integer sortNum;

    /**
     * 录入时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 上架时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Shanghai")
    private Date putawayDate;

    /**
     * 乐观锁 版本号
     */
    private Integer version;

    private static final long serialVersionUID = 1L;
}