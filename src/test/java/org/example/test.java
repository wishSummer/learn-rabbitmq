package org.example;

import org.example.constent.RabbitConstent;
import org.junit.jupiter.api.Test;
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

    @Qualifier(value = "firstRabbitTemplate")
    @Autowired
    private RabbitTemplate firstRabbitTemplate;

    @Qualifier(value = "secondRabbitTemplate")
    @Autowired
    private RabbitTemplate secondRabbitTemplate;


    @Test
    void test() {
//        firstRabbitTemplate.convertAndSend(RabbitConstent.CHAT_ROOM,"send message");
        secondRabbitTemplate.convertAndSend(RabbitConstent.DIRECT_EXCHANGE, RabbitConstent.CHAT_ROOM, "send message");
    }


}
