package site.waconde;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
public class SpringAdminClientClusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAdminClientClusterApplication.class, args);
    }

}
