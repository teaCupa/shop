package org.yh.shop.model.vo;

import lombok.Data;
import org.yh.shop.model.Product;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/11/25
 * @Description:
 */

@Data
public class ProductVo implements Serializable {
    private Product product;
    private List<PropVo> propVos;
    private List<SpuSkuRelVo> spuSkuRelVos;
}
