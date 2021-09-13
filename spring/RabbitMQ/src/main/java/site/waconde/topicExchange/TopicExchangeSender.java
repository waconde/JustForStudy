package site.waconde.topicExchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * binding key匹配规则：
 * 未匹配的消息会丢弃
 * 已匹配的消息会继续试图匹配后续的route key，直到无匹配项
 *
 * @author side.wang
 * @since 2019年9月23日
 */
@Component
public class TopicExchangeSender {
    private static final Logger log = LoggerFactory.getLogger(TopicExchangeSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage1() {
        String message = "this is ROUTE_KEY1";
        rabbitTemplate.convertAndSend(TopicExchangeConfig.EXCHANGE_NAME, "register.message", message);
        log.info("Sender1: " + message);
    }

    public void sendMessage2() {
        String message = "this is ROUTE_KEY2";
        rabbitTemplate.convertAndSend(TopicExchangeConfig.EXCHANGE_NAME, "send.message", message);
        log.info("Sender2: " + message);
    }

    public void sendMessage3() {
        String message = "this is ROUTE_KEY3";
        rabbitTemplate.convertAndSend(TopicExchangeConfig.EXCHANGE_NAME, "send.register.message", message);
        log.info("Sender3: " + message);
    }

    public void sendMessage4() {
        String message = "this is ROUTE_KEY4";
        rabbitTemplate.convertAndSend(TopicExchangeConfig.EXCHANGE_NAME, "register.send", message);
        log.info("Sender4: " + message);
    }

    public void sendMessage5() {
        String message = "this is ROUTE_KEY5";
        rabbitTemplate.convertAndSend(TopicExchangeConfig.EXCHANGE_NAME, "send.register.message", message);
        log.info("Sender5: " + message);
    }
}
