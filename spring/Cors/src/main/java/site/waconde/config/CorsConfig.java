package site.waconde.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * 跨域配置 跨域请求，就是说浏览器在执行脚本文件的ajax请求时，脚本文件所在的服务地址和请求的服务地址不一样。说白了就是ip、网络协议、端口都一样的时候，就是同一个域，否则就是跨域。这是由于Netscape
 * 提出一个著名的安全策略——同源策略造成的，这是浏览器对JavaScript施加的安全限制。是防止外网的脚本恶意攻击服务器的一种措施。
 * “*”代表全部。”**”代表适配所有接口。其中addAllowedOrigin(String origin)方法是追加访问源地址。如果不使用”*”（即允许全部访问源），则可以配置多条访问源来做控制。
 * //corsConfiguration.addAllowedOrigin("http://www.aimaonline.cn/");
 * //corsConfiguration.addAllowedOrigin("http://test.aimaonline.cn/");
 * 整个Controller进行跨域设置：@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
 *
 * @author cuids
 * @email desheng.cui@baifendian.com
 * @date 2017-07-14 18:08:25
 */
//@Configuration
public class CorsConfig {
    /*@Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedMethod("*");
        config.addAllowedOrigin("http://localhost:8080");
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);
    
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);
    
        return new CorsWebFilter(source);
    }
    */
}
