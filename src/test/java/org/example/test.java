package org.example;

import org.example.constent.RabbitConstent;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description:
 *
 * @author < a href="wangfc@hzwesoft.com">wangfc</ a>
 * @version $ Id: test.java, 2024/6/27 下午5:45 $
 */
@SpringBootTest
public class test {

    @Qualifier(value = "secondRabbitTemplate")//fistRabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier(value = "secondConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Autowired
    private ConnectionFactory autoconnectionFactory;

    @Test
    void test() {
        rabbitTemplate.send("amq.direct", RabbitConstent.CHAT_ROOM, new Message("send message".getBytes()));
    }


}
