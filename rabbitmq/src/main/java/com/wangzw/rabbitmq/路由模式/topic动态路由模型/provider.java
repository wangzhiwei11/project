package com.wangzw.rabbitmq.路由模式.topic动态路由模型;

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
        channel.exchangeDeclare("topicExchage", BuiltinExchangeType.TOPIC);
        String routingKey = "user.save";
//        String routingKey = "user.save.test";
        channel.basicPublish("topicExchage",routingKey,null,("topic 模式发送依赖routing key:"+routingKey).getBytes());
        channel.close();
        connection.close();
    }
}
