package site.waconde.pageLearn.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description: PageConfig <br>
 * date: 2019/12/13 11:23 <br>
 * author: side.wang <br>
 */
@Configuration
@MapperScan("site.waconde.pageLearn.mapper")
public class PageConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
