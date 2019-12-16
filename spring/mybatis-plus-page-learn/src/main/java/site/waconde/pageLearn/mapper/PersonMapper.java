package site.waconde.pageLearn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import site.waconde.pageLearn.dto.Person;

/**
 * description: PersonMapper.xml <br>
 * date: 2019/12/13 11:41 <br>
 * author: side.wang <br>
 */
@Mapper
public interface PersonMapper extends BaseMapper<Person> {

}
