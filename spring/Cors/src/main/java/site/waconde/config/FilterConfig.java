package site.waconde.config;

import javax.servlet.DispatcherType;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * filter配置
 *
 * @author side.wang
 * @since 2019年10月29日
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean crossFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new CorsFilter());
        registration.addUrlPatterns("/*");
        registration.setName("corsFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }
}
