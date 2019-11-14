package site.waconde;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import site.waconde.rabbitmq.RabbitMQSender;
import site.waconde.topicExchange.TopicExchangeSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqApplicationTests {
    @Autowired
    private RabbitMQSender rabbitMQ;
    
    @Autowired
    private TopicExchangeSender topicExchangeSender;
    
    @Test
    public void oneToOne() {
        rabbitMQ.send();
    }
    
    @Test
    public void oneToMany() {
        for(int i = 0; i < 100; i ++)
            rabbitMQ.send("this is " + i);
    }
    
    @Test
    public void topicExchangeTest12() throws InterruptedException {
        for(int i = 0; i < 10; i ++) {
            //Thread.currentThread().sleep(1000);//毫秒   
            if(Math.random() > 0.5)
                topicExchangeSender.sendMessage1();
            else 
                topicExchangeSender.sendMessage2();
        }
    }
    
    @Test
    public void topicExchangeTest34() throws InterruptedException {
        for(int i = 0; i < 10; i ++) {
            //Thread.currentThread().sleep(1000);//毫秒   
            if(Math.random() > 0.5)
                topicExchangeSender.sendMessage3();
            else 
                topicExchangeSender.sendMessage4();
        }
    }
    
    @Test
    public void topicExchangeTest45() throws InterruptedException {
        for(int i = 0; i < 10; i ++) {
            if(Math.random() > 0.5)
                topicExchangeSender.sendMessage4();
            else 
                topicExchangeSender.sendMessage5();
        }
    }
}
