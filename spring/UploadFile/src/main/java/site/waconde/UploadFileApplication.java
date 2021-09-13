package site.waconde;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UploadFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadFileApplication.class, args);
    }

    /*
     * 添加tomcat上传文件大小限制，默认为10，-1则无限制
     */
    @Bean
    public TomcatServletWebServerFactory tomcatEmbedded() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1代表无限制，建议加限制
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(10);
            }
        });
        return tomcat;
    }
}
