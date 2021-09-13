package site.waconde.config;

import java.io.IOException;
import java.net.InetSocketAddress;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import net.spy.memcached.MemcachedClient;

/**
 * 利用 CommandLineRunner 在项目启动的时候配置好 MemcachedClient
 *
 * @author side.wang
 */
@Component
public class MemcachedRunner implements CommandLineRunner {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private MemcacheSource memcacheSource;

    private MemcachedClient client = null;

    @Override
    public void run(String... args) throws Exception {
        try {
            client = new MemcachedClient(new InetSocketAddress(memcacheSource.getIp(), memcacheSource.getPort()));
        } catch (IOException e) {
            logger.error("inint MemcachedClient failed ", e);
        }
    }

    public MemcachedClient getClient() {
        return client;
    }
}
