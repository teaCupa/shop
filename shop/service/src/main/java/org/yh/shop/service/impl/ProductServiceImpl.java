package org.yh.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yh.shop.common.PageBean;
import org.yh.shop.dao.ProductDao;
import org.yh.shop.dao.PropNameDao;
import org.yh.shop.dao.PropValueDao;
import org.yh.shop.dao.SkuDao;
import org.yh.shop.model.Category;
import org.yh.shop.model.Product;
import org.yh.shop.model.PropName;
import org.yh.shop.model.PropValue;
import org.yh.shop.model.vo.ProductVo;
import org.yh.shop.model.vo.PropVo;
import org.yh.shop.model.vo.SpuSkuRelVo;
import org.yh.shop.service.ProductService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/11/22
 * @Description: 增删改查，划分为2类：查询和更新操作(增删改)
 */

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    @Autowired
    PropNameDao propNameDao;
    @Autowired
    PropValueDao propValueDao;
    @Autowired
    SkuDao skuDao;

    @Override
    public List<Product> getProduct() {
        return productDao.selectAll();
    }

    /**
     *   默认值1,10的巧妙之处在于，默认从第一个数据开始检索10个数据
     */
    @Override
    public PageBean getProductByPage(Integer page, Integer size, String name) {
        if(page!=null &&size !=null){
            page=(page-1)*size;   //从第page个记录起(不包含page)，查询size个数据
        }
        List<Product>products=productDao.getProductsByPage(page,size,name);
        //如果关键字不为Null，按关键字查总记录
        Long total=productDao.getProductsTotal(name);
        PageBean bean = new PageBean();
        bean.setData(products);
        bean.setTotal(total);
        return bean;
    }

    @Override
    public ProductVo getProductVoById(Integer id) {
        ProductVo productVo = new ProductVo();
        Product product = productDao.selectByPrimaryKey(Long.valueOf(id));
        if (product == null) {
            throw new RuntimeException("查询为空");
        }
        List<PropName> propNames = propNameDao.selectByPIds(product.getId());
        List<PropValue> propValues = propValueDao.selectByPIds(product.getId());
        List<PropVo> propVos = new ArrayList<>();
        if (propNames == null || propValues == null) {
            throw new RuntimeException("查询为空");
        }
        for (PropName p : propNames) {
            PropVo propVo = new PropVo();
            List<PropValue> pv = new ArrayList<>();
            for (PropValue propValue : propValues) {
                if (propValue.getPropNameId().equals(p.getPropNameId())) {  //属性名id
                    pv.add(propValue);
                }
            }
            propVo.setPropNameId(p.getPropNameId());
            propVo.setPropName(p.getPropName());
            propVo.setPropValues(pv);
            propVos.add(propVo);
        }
        productVo.setProduct(product);
        productVo.setPropVos(propVos);
        List<SpuSkuRelVo> spuSkuRelVos = skuDao.selectByPropSpuId(id);
        System.out.println(spuSkuRelVos);
        productVo.setSpuSkuRelVos(spuSkuRelVos);
        return productVo;
    }

    //插入category表产品的同时也创建一个新Product
    @Override
    public void insertByCate(Category record) {
        Product p = new Product();
        p.setCategoryId(record.getId());
        p.setCreateDate(new Date());
        p.setPutawayDate(new Date());
        p.setName(record.getName());
        p.setStatus(true);
        p.setSortNum(record.getSeq());
        p.setPic(record.getCategoryPic());
        productDao.insertSelective(p);
    }

    @Override
    public int save(Product product) {
        if(product.getId()==null || product.getId()==0){
            //handle insert
        }
        product.setUpdateDate(new Date());
        productDao.updateByPrimaryKeySelective(product);
        return 1;
    }

    @Override
    public List<Product> getAllProduct() {
        return productDao.selectAlls();
    }

}
