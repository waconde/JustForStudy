package site.waconde.pageLearn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.waconde.pageLearn.dto.Person;
import site.waconde.pageLearn.mapper.PersonMapper;
import site.waconde.pageLearn.service.PersonService;

/**
 * description: PersonServiceImpl <br>
 * date: 2019/12/13 11:49 <br>
 * author: side.wang <br>
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;

    @Override
    public IPage<Person> getAllInfo(Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageNo == 0 || pageSize == null || pageNo == 0) {
            throw new IllegalArgumentException("pageNo and pageSize can't be null or zero");
        }
        IPage<Person> page = new Page<>(pageNo, pageSize);

        QueryWrapper<Person> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 18);

        return personMapper.selectPage(page, queryWrapper);
    }
}
