package com.xxxx.server.controller;


import com.xxxx.server.entity.Menu;
import com.xxxx.server.service.AdminService;
import com.xxxx.server.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author server
 * @since 2021-05-03
 */
@RestController
@RequestMapping("/system/cfg")
public class MenuController {
    @Autowired
    private MenuService menuService;


    @ApiOperation(value = "通过用户ID查询菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenusByAdminId(){
        return menuService.getMenuByAdminId();

    }

}

