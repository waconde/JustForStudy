package site.waconde.topicExchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Topic交换机配置。
 * route key和binding key必须为“.”分隔的字符串
 * *：匹配任意一个单词
 * #：匹配任意零个到多个单词
 * 1、队列
 * 2、交换机
 * 3、绑定
 *
 * @author side.wang
 * @since 2019年9月19日
 */
@Configuration
public class TopicExchangeConfig {
    final static String QUEUE_NAME1 = "registerQueue";
    final static String QUEUE_NAME2 = "sendQueue";
    final static String QUEUE_NAME3 = "sendQueue2";
    final static String EXCHANGE_NAME = "topicExchange";
    final static String ROUTE_KEY1 = "register.*";
    final static String ROUTE_KEY2 = "send.#";
    final static String ROUTE_KEY3 = "#.send.#";
    private static final Logger log = LoggerFactory.getLogger(TopicExchangeConfig.class);


    // 创建队列1
    @Bean
    public Queue topicQueue1() {
        return new Queue(TopicExchangeConfig.QUEUE_NAME1);
    }

    // 创建队列2
    @Bean
    public Queue topicQueue2() {
        return new Queue(TopicExchangeConfig.QUEUE_NAME2);
    }

    // 创建队列2
    @Bean
    public Queue topicQueue3() {
        return new Queue(TopicExchangeConfig.QUEUE_NAME3);
    }

    // 创建Topic交换机
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(TopicExchangeConfig.EXCHANGE_NAME);
    }

    // 绑定队列1到交换机。spring自动靠名字匹配注入
    @Bean
    Binding bindingExchange1(Queue topicQueue1, TopicExchange exchange) {
        log.info("binding to TopicExchange use " + TopicExchangeConfig.ROUTE_KEY1);
        return BindingBuilder.bind(topicQueue1).to(exchange).with(TopicExchangeConfig.ROUTE_KEY1);
    }

    // 绑定队列2到交换机
    @Bean
    Binding bindingExchange2(Queue topicQueue2, TopicExchange exchange) {
        log.info("binding to TopicExchange use " + TopicExchangeConfig.ROUTE_KEY2);
        return BindingBuilder.bind(topicQueue2).to(exchange).with(TopicExchangeConfig.ROUTE_KEY2);
    }

    // 绑定队列3到交换机
    @Bean
    Binding bindingExchange3(Queue topicQueue3, TopicExchange exchange) {
        log.info("binding to TopicExchange use " + TopicExchangeConfig.ROUTE_KEY3);
        return BindingBuilder.bind(topicQueue3).to(exchange).with(TopicExchangeConfig.ROUTE_KEY3);
    }
}
