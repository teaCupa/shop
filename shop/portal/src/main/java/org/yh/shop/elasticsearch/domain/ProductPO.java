package org.yh.shop.elasticsearch.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: yh
 * @Date: 2021/3/1
 * @Description:
 */

@Data
@Document(indexName = "product")
public class ProductPO {
    @Id
    private Long id;

    /**
     * SKU名称
     * FieldType.Text支持分词
     * analyzer 创建索引的分词器
     * searchAnalyzer 搜索时使用的分词器
     */
    @Field(type = FieldType.Text, analyzer = "ik_smart",searchAnalyzer = "ik_smart")
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
}
