package org.yh.shop.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * category
 * @author 
 */
@Data
@ApiModel(value = "Category",description = "种类")
public class Category implements Serializable {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "name",notes = "名称",dataType = "String")
    private String name;

    /**
     * 父级Id
     */
    @ApiModelProperty(value = "parentId")
    private Integer parentId;

    /**
     * 排序
     */
    @ApiModelProperty(value = "seq")
    private Integer seq;

    /**
     * 图片
     */
    @ApiModelProperty(value = "categoryPic")
    private String categoryPic;

    @ApiModelProperty(value = "status")
    private Boolean status;

    @ApiModelProperty(value = "createDate")
    private Date createDate;

    @ApiModelProperty(value = "updateDate")
    private Date updateDate;

    //非数据库字段
    private String parentName;
    //非数据库字段
    private List<Category>children;
    //非数据库字段
    private Integer level;



    private static final long serialVersionUID = 1L;
}