package org.yh.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yh.shop.dao.PropNameDao;
import org.yh.shop.model.vo.PropNameVo;
import org.yh.shop.service.PropNameService;

import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/12/26
 * @Description:
 */

@Service
public class PropNameServiceImpl implements PropNameService {
    @Autowired
    PropNameDao propNameDao;

    @Override
    public List<PropNameVo> findAll() {
        return propNameDao.findAll();
    }
}
