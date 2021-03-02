package org.yh.shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.model.SysMenu;
import org.yh.shop.service.SysMenuService;
import org.yh.shop.utils.CurdUtil;

import java.util.List;

/**
 * 菜单控制器
 * @author Louis
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {

	@Autowired
	private SysMenuService sysMenuService;
	
	@PreAuthorize("hasAuthority('sys:menu:add') AND hasAuthority('sys:menu:edit')")
	@PostMapping(value="/save")
	public ResponseEntity save(@RequestBody SysMenu record) {
		return 	CurdUtil.update(sysMenuService.save(record));
	}

	@PreAuthorize("hasAuthority('sys:menu:delete')")
	@PostMapping(value="/delete")
	public ResponseEntity delete(@RequestBody List<SysMenu> records) {
		return CurdUtil.update(sysMenuService.delete(records));
	}

	@PreAuthorize("hasAuthority('sys:menu:view')")
	@GetMapping(value="/findNavTree")
	public ResponseEntity findNavTree(@RequestParam String username) {
		return CurdUtil.find(sysMenuService.findTree(username, 0));
	}
	
	@PreAuthorize("hasAuthority('sys:menu:view')")
	@GetMapping(value="/findMenuTree")
	public ResponseEntity findMenuTree() {
		return CurdUtil.find(sysMenuService.findTree(null, 1));
	}
}
