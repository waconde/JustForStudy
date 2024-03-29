package site.waconde;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableAdminServer
public class SpringAdminClusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAdminClusterApplication.class, args);
    }

}
