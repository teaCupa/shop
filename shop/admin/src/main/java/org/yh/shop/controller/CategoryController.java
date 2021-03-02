package org.yh.shop.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.model.Category;
import org.yh.shop.service.CategoryService;
import org.yh.shop.utils.CurdUtil;

import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/12/24
 * @Description:
 */

@Api(tags = "CategoryController", description = "商品种类管理")
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @ApiOperation("获取所有商品种类")
    @GetMapping("/findAll")
    @ApiResponses({@ApiResponse(code = 200,message = "ok",response = ResponseEntity.class)})
    @PreAuthorize("hasAuthority('prod:cate:view')")
    public ResponseEntity findAll(){
        return CurdUtil.find(categoryService.findAll());
    }

    @PostMapping("/save")
//    @ApiImplicitParams({
//            @ApiImplicitParam (paramType= "body",name = "name",value = "种类名称",required = true,defaultValue = "手机数码"),
//            @ApiImplicitParam (paramType= "query",name = "parentId",value = "上一级ID",defaultValue = "0")})
    @PreAuthorize("hasAuthority('prod:cate:add') AND hasAuthority('prod:cate:edit')")
    public ResponseEntity save(@RequestBody Category record){
        return CurdUtil.update(categoryService.save(record));
    }

    @ApiOperation("删除商品种类")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('prod:cate:delete')")
    public ResponseEntity delete(@ApiParam(value = "删除种类参数",required = true) @RequestBody List<Category> categories){
        return CurdUtil.update(categoryService.delete(categories));
    }
}
