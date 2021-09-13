package site.waconde.pageLearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("site.waconde.pageLearn.mapper")
public class MybatisPlusPageLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusPageLearnApplication.class, args);
    }

}
