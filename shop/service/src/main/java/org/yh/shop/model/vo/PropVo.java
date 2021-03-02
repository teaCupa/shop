package org.yh.shop.model.vo;

import lombok.Data;
import org.yh.shop.model.PropName;
import org.yh.shop.model.PropValue;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/11/28
 * @Description:
 */

@Data
public class PropVo extends PropName implements Serializable {
    private List<PropValue> propValues;
}
