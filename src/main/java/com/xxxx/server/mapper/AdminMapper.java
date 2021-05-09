package com.xxxx.server.mapper;

import com.xxxx.server.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.entity.Menu;
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
public interface AdminMapper extends BaseMapper<Admin> {

}
