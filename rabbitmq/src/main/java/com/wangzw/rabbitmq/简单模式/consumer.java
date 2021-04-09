package com.wangzw.rabbitmq.简单模式;

import com.rabbitmq.client.*;
import com.wangzw.rabbitmq.RabbitUtil;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author wangzw
 * @date 2021/4/9 10:59
 */
public class consumer {
    public static void main(String[] args) throws Exception{
        Connection connection = RabbitUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello",true,false,false,null);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(
                    String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                    byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        };
        channel.basicConsume("hello",true,consumer);
    }
}
