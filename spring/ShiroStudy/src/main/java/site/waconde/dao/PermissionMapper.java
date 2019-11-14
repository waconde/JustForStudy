package site.waconde.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import site.waconde.entity.PermissionInfo;

@Mapper
public interface PermissionMapper extends BaseMapper<PermissionInfo> {

}
