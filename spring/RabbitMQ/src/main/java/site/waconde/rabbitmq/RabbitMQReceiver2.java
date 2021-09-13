package site.waconde.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收方
 * 需要注册RabbitMQ监听器，填上配置的队列名。
 *
 * @author side.wang
 * @since 2019年9月19日
 */
@Component
@RabbitListener(queues = "OneRabbitMQ")
public class RabbitMQReceiver2 {
    @RabbitHandler
    public void process(String message) {
        System.out.println("Receive2:this is " + message);
    }
}
