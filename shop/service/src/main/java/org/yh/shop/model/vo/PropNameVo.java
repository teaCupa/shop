package org.yh.shop.model.vo;

import lombok.Data;
import org.yh.shop.model.PropName;
import org.yh.shop.model.PropValue;

import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/12/26
 * @Description:
 */

@Data
public class PropNameVo extends PropName {
    private List<PropValue> propValues;
}
