package site.waconde;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
// @SpringBootApplication
public class SpringAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAdminApplication.class, args);
	}

}
