package org.example.Listener;

import org.example.constent.RabbitConstent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author < a href="wangfc@hzwesoft.com">wangfc</ a>
 * @version $ Id: ChatRoomListener.java, 2024/6/27 下午5:42 $
 */
@Component
public class ChatRoomListener {

    @Qualifier(value = "secondRabbitTemplate")
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = {RabbitConstent.CHAT_ROOM}, containerFactory = "secondFactory")
    public void processMessage(String message) {
        // 处理接收到的消息
        System.out.println("Received message from myQueue: " + message);
//        rabbitTemplate.convertAndSend(RabbitConstent.CHAT_ROOM, message);

    }

}
