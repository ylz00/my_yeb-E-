package com.xxxx.server.service.impl;

import com.xxxx.server.entity.Employee;
import com.xxxx.server.mapper.EmployeeMapper;
import com.xxxx.server.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author server
 * @since 2021-05-03
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
