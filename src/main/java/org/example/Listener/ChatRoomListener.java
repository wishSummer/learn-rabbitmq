package org.example.Listener;

import lombok.extern.slf4j.Slf4j;
import org.example.constent.RabbitConstent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.backoff.Sleeper;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author < a href="wangfc@hzwesoft.com">wangfc</ a>
 * @version $ Id: ChatRoomListener.java, 2024/6/27 下午5:42 $
 */
@Component
@Slf4j
public class ChatRoomListener {

    @Qualifier(value = "firstRabbitTemplate")
    @Autowired
    private RabbitTemplate firstRabbitTemplate;

    @Qualifier(value = "secondRabbitTemplate")
    @Autowired
    private RabbitTemplate secondRabbitTemplate;

    @RabbitListener(queues = {RabbitConstent.CHAT_ROOM}, containerFactory = "firstFactory")
    public void chatRoom(String message) {
        log.info("chatRoom : {}", message);
        secondRabbitTemplate.convertAndSend(RabbitConstent.DIRECT_EXCHANGE, RabbitConstent.CHAT_ROOM, message);
        firstRabbitTemplate.convertAndSend(RabbitConstent.DIRECT_EXCHANGE, RabbitConstent.CHAT_ROOM, message);
    }

    @RabbitListener(queues = {RabbitConstent.MESSAGE}, containerFactory = "firstFactory")
    public void message(String message) {
        log.info("message : {}", message);
        secondRabbitTemplate.convertAndSend(RabbitConstent.DIRECT_EXCHANGE, RabbitConstent.MESSAGE, message);
        firstRabbitTemplate.convertAndSend(RabbitConstent.DIRECT_EXCHANGE, RabbitConstent.MESSAGE, message);
    }

    @RabbitListener(queues = {RabbitConstent.IMAGE_FLAG}, containerFactory = "firstFactory")
    public void Image(String message) {
        log.info("image : {}", message);
        secondRabbitTemplate.convertAndSend(RabbitConstent.DIRECT_EXCHANGE, RabbitConstent.IMAGE_FLAG, message);
        firstRabbitTemplate.convertAndSend(RabbitConstent.DIRECT_EXCHANGE, RabbitConstent.IMAGE_FLAG, message);
    }

    @RabbitListener(queues = {RabbitConstent.CONTACT}, containerFactory = "firstFactory")
    public void contact(String message) {
        log.info("contact : {}", message);
        secondRabbitTemplate.convertAndSend(RabbitConstent.DIRECT_EXCHANGE, RabbitConstent.CONTACT, message);
        firstRabbitTemplate.convertAndSend(RabbitConstent.DIRECT_EXCHANGE, RabbitConstent.CONTACT, message);
    }

}
