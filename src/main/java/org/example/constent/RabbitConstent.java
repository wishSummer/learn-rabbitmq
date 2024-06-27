package org.example.constent;

/**
 * Description:
 *
 * @author < a href="wangfc@hzwesoft.com">wangfc</ a>
 * @version $ Id: RabbitConstent.java, 2024/6/27 下午4:22 $
 */
public interface RabbitConstent {

    /**
     * 全量微信群
     */
    String CHAT_ROOM  = "chat-room";

    /**
     * 全量好友
     */
    String CONTACT    = "contact";

    /**
     * 全量好友图片
     */
    String IMAGE_FLAG = "image-flag";

    /**
     * 增量微信消息队列
     */
    String MESSAGE    = "message";
}
