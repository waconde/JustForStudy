package site.waconde.rabbitmq;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送方
 * 需要指定向哪个队列发送消息。
 *
 * @author side.wang
 * @since 2019年9月19日
 */
@Component
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello, this is " + new Date();
        System.out.println("Sender:" + context);
        rabbitTemplate.convertAndSend("OneRabbitMQ", context);
    }

    public void send(String string) {
        System.out.println("Sender:this is " + string);
        rabbitTemplate.convertAndSend("OneRabbitMQ", string);
    }

}
