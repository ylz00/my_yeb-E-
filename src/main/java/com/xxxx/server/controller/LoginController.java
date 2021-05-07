package com.xxxx.server.controller;

import com.xxxx.server.dto.RespBean;
import com.xxxx.server.entity.Admin;
import com.xxxx.server.service.AdminService;
import com.xxxx.server.vo.AdminLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @Author
 * @create
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {

    @Autowired
    private AdminService adminService;


    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginVO tAdminLoginVO, HttpServletRequest request){

        return adminService.login(tAdminLoginVO.getUsername(),tAdminLoginVO.getPassword(),tAdminLoginVO.getCode(),request);

    }

    @ApiOperation(value = "获取当前用户信息")
    @GetMapping("/admin/info")
    public Admin getTAminInfo(Principal principal){
        if (null==principal){
            return null;
        }
        String username =principal.getName();
        Admin admin =adminService.getAminByUserName(username);
        admin.setPassword(null);
        return admin;
    }


    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功！");
    }
}
