package site.waconde.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner/ApplicationRunner：spring boot初始化工具，两者run方法参数不同
 * 实现CommandLineRunner/ApplicationRunner接口的component会在所有spring bean都初始化之后，
 * 启动类SpringApplication.run();方法执行之前执行，
 * 负责在程序启动之初执行数据的初始化工作。
 * 可以通过@Order注解进行排序，将会按顺序执行数据初始化
 * @author side.wang
 *
 */
@Component
@Order(2)
public class Runner2 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("service2 start to initalize...");
    }

}
