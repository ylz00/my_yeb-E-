package com.xxxx.server.service.impl;

import com.xxxx.server.entity.Admin;
import com.xxxx.server.entity.Menu;
import com.xxxx.server.mapper.MenuMapper;
import com.xxxx.server.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author server
 * @since 2021-05-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 通过用户ID查询菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenuByAdminId() {

//        return menuMapper.getMenuByAdminId(((Admin) SecurityContextHolder.getContext().getAuthentication()).getId());
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal()).getId();
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        // 从redis获取菜单数据
        List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + adminId);
        // 如果为空，去数据库获取
        if (CollectionUtils.isEmpty(menus)) {
            menus = menuMapper.getMenuByAdminId(adminId);
            //将数据设置到Redis中
            valueOperations.set("menu_"+adminId, menus);
        }
        return menus;
    }
}
