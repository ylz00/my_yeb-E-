package com.xxxx.server.service;

import com.xxxx.server.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author server
 * @since 2021-05-03
 */
public interface MenuService extends IService<Menu> {
    /**
     * 通过用户ID查询菜单列表
     * @return
     */
    List<Menu> getMenuByAdminId();
}
