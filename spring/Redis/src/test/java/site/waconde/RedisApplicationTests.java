package site.waconde;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;
import site.waconde.study.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void cacheString() {
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.set("testForString", "qwertyuiopasdffgdhjhklzxvcvbm", 3000, TimeUnit.SECONDS);
        System.out.println(opsForValue.get("testForString"));
    }

    @Test
    public void cacheObject() {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("testForObject1", new User("褚凯迪", 32), 3000, TimeUnit.SECONDS);
        opsForValue.set("testForObject2", new User("卢妮武", 25), 3000, TimeUnit.SECONDS);
        Assert.assertEquals(Boolean.TRUE, redisTemplate.hasKey("testForObject1"));
        System.out.println(opsForValue.get("testForObject1"));
        User testForObject1 = (User) opsForValue.get("testForObject1");
        System.out.println(testForObject1);
    }

    @Test
    public void cacheMap() {
        HashOperations<String, Object, Object> stringObjectObjectHashOperations = redisTemplate.opsForHash();
        stringObjectObjectHashOperations.put("testForHash1", "name", "缇娜");
        stringObjectObjectHashOperations.put("testForHash2", "name", "明发");
        Assert.assertEquals(Boolean.TRUE, redisTemplate.hasKey("testForHash1"));
        System.out.println(stringObjectObjectHashOperations.get("testForHash1", "name"));
    }

    @Test
    public void cacheList() {
        ListOperations<String, Object> stringObjectListOperations = redisTemplate.opsForList();
        List<User> users = new ArrayList<>();
        users.add(new User("吴敏", 22));
        users.add(new User("哦民", 21));
        users.add(new User("迷宫", 23));
        stringObjectListOperations.rightPushAll("testForList", users.toArray());
        Assert.assertEquals(Boolean.TRUE, redisTemplate.hasKey("testForList"));
        User user = (User) stringObjectListOperations.leftPop("testForList");
        System.out.println(user);
        List<Object> testForList = stringObjectListOperations.range("testForList", 0, users.size());
        assert testForList != null;
        testForList.forEach(System.out::println);
    }
}
