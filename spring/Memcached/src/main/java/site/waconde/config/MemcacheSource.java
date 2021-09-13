package site.waconde.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// @ConfigurationProperties(prefix = "memcache")会以 memcache.* 为前缀将对应的配置项加载到属性中
@Component
@ConfigurationProperties(prefix = "memcache")
public class MemcacheSource {
    private String ip;
    private int port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "MemcacheSource [ip=" + ip + ", port=" + port + "]";
    }
}
