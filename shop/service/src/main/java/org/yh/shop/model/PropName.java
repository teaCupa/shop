package org.yh.shop.model;

import lombok.Data;

import java.io.Serializable;

/**
 * prop_name
 * @author 
 */
@Data
public class PropName implements Serializable {
    private Integer id;

    private Integer propNameId;

    private String propName;


    private static final long serialVersionUID = 1L;
}