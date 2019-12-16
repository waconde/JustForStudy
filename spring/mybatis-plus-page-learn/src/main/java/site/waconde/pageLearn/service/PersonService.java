package site.waconde.pageLearn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import site.waconde.pageLearn.dto.Person;

/**
 * description: PersonService <br>
 * date: 2019/12/13 11:47 <br>
 * author: side.wang <br>
 */
public interface PersonService {
    IPage<Person> getAllInfo(Integer pageNo, Integer pageSize);
}
