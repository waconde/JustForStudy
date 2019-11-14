package site.waconde.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import site.waconde.entity.RolePermissionInfo;

@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermissionInfo> {

}
