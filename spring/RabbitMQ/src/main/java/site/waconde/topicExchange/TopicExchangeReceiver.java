package site.waconde.topicExchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicExchangeReceiver {
    private static final Logger log = LoggerFactory.getLogger(TopicExchangeReceiver.class);

    @RabbitListener(queues = TopicExchangeConfig.QUEUE_NAME1)
    public void recevieMessage1(String message) {
        log.info("Recevier1: " + message);
    }

    @RabbitListener(queues = TopicExchangeConfig.QUEUE_NAME2)
    public void recevieMessage2(String message) {
        log.info("Recevier2: " + message);
    }

    @RabbitListener(queues = TopicExchangeConfig.QUEUE_NAME3)
    public void recevieMessage3(String message) {
        log.info("Recevier3: " + message);
    }
}
