package org.yh.shop.model;

import lombok.Data;

import java.io.Serializable;

/**
 * prop_value
 * @author 
 */
@Data
public class PropValue implements Serializable {
    private Integer id;

    private Integer propValueId;

    private String propValue;

    private Integer propNameId;

    private static final long serialVersionUID = 1L;
}