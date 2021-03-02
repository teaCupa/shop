package org.yh.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.service.SysUserService;
import org.yh.shop.utils.CurdUtil;

/**
 * @Author: yh
 * @Date: 2020/12/23
 * @Description:
 */

@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value="/findPermissions")
    public ResponseEntity findPermissions(@RequestParam String name) {
          return CurdUtil.find(sysUserService.findPermissions(name));
    }

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value="/findByName")
    public ResponseEntity findByUserName(@RequestParam String name) {
        return CurdUtil.find(sysUserService.findByName(name));
    }
}
