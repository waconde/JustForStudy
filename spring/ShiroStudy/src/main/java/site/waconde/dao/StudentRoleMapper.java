package site.waconde.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import site.waconde.entity.StudentRoleInfo;

@Mapper
public interface StudentRoleMapper extends BaseMapper<StudentRoleInfo> {
    
}
