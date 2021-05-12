package com.xxxx.server.mapper;

import com.xxxx.server.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author server
 * @since 2021-05-03
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 通过用户ID查询菜单列表
     * @param id
     * @return
     */

    List<Menu> getMenuByAdminId(Integer id);

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();
}
