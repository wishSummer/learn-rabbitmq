package org.example.domain;

import lombok.Data;

/**
 * Description:
 *
 * @author < a href="wangfc@hzwesoft.com">wangfc</ a>
 * @version $ Id: RabbitConfigerWrap.java, 2024/6/27 下午4:28 $
 */
@Data
public class RabbitConfiger {
    private String host;
    private int port;
    private String username;
    private String password;

}
