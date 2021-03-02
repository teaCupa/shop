package org.yh.shop.model.vo;

import lombok.Data;
import org.yh.shop.model.Sku;
import org.yh.shop.model.SpuSkuRel;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/11/29
 * @Description:
 */

@Data
public class SpuSkuRelVo extends Sku implements Serializable {
    private List<SpuSkuRel> spuSkuRels;
}
