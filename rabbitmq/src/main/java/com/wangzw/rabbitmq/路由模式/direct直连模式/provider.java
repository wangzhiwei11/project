package com.wangzw.rabbitmq.路由模式.direct直连模式;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wangzw.rabbitmq.RabbitUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <p>
 * </p>
 *
 * @author wangzw
 * @date 2021/4/9 10:45
 */
public class provider {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("directExchage", BuiltinExchangeType.DIRECT);
        String routingKey = "error";
//        String routingKey = "info";
        channel.basicPublish("directExchage",routingKey,null,("direct 模式发送依赖routing key:"+routingKey).getBytes());
        channel.close();
        connection.close();
    }
}
