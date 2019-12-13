package site.waconde.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import site.waconde.entity.RoleInfo;

@Mapper
public interface RoleMapper extends BaseMapper<RoleInfo> {

}
