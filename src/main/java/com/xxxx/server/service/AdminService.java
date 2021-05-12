package com.xxxx.server.service;

import com.xxxx.server.dto.RespBean;
import com.xxxx.server.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.entity.Menu;
import com.xxxx.server.entity.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author server
 * @since 2021-05-03
 */

public interface AdminService extends IService<Admin> {
    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    Admin getAminByUserName(String username);

    /**
     * 根据用户id查询角色列表
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);
}
