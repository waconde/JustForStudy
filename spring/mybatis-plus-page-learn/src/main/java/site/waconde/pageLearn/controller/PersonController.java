package site.waconde.pageLearn.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.waconde.pageLearn.dto.Person;
import site.waconde.pageLearn.service.PersonService;

import java.util.Map;

/**
 * description: getAllInfo <br>
 * date: 2019/12/13 11:28 <br>
 * author: side.wang <br>
 */
@RestController
@RequestMapping("/pageLearn")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/getAllInfo")
    public IPage<Person> getAllInfo(@RequestBody Map<String, Integer> pageInfo) {
        return personService.getAllInfo(pageInfo.get("pageNo"), pageInfo.get("pageSize"));
    }
}
