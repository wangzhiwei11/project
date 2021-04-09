package com.wangzw.rabbitmq.fanout模式;

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
        channel.exchangeDeclare("fanoutExchange", BuiltinExchangeType.FANOUT);
        channel.basicPublish("fanoutExchange","",null,"fanout hello word".getBytes());
        channel.close();
        connection.close();
    }
}
