package org.yh.shop.model;

import java.io.Serializable;
import lombok.Data;

/**
 * spu_sku_rel
 * @author 
 */
@Data
public class SpuSkuRel implements Serializable {
    private Integer id;

    /**
     * 产品id
     */
    private Integer spuId;

    private Integer skuId;

    /**
     * 对应属性名如颜色，内存等
     */
    private Integer propNameId;

    /**
     * 具体属性如红色，64G 
     */
    private Integer propValueId;

    private static final long serialVersionUID = 1L;
}