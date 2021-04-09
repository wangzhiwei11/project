package com.wangzw.rabbitmq.路由模式.direct直连模式;

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
public class consumer2 {
    public static void main(String[] args) throws Exception{
        Connection connection = RabbitUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("directExchage", BuiltinExchangeType.DIRECT);
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue,"directExchage","error");
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(
                    String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                    byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        };
        channel.basicConsume(queue,true,consumer);
    }
}
