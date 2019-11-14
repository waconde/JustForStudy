package site.waconde;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("site.waconde.dao")
@SpringBootApplication
public class ShiroStudyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ShiroStudyApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(ShiroStudyApplication.class);
	}
}
