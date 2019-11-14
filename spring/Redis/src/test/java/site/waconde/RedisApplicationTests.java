package site.waconde;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import site.waconde.study.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    @Test
    public void cacheString() {
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.set("testForString", "qwertyuiopasdffgdhjhklzxvcvbm", 3000);
        System.out.println(opsForValue.get("testForString"));
    }

    @Test
    public void cacheObject() {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("testForObject1", new User("褚凯迪", 32), 3000);
        opsForValue.set("testForObject2", new User("卢妮武", 25), 3000);
        Assert.assertEquals(Boolean.valueOf(true), redisTemplate.hasKey("testForObject1"));
        System.out.println(opsForValue.get("testForObject1"));
    }
}
