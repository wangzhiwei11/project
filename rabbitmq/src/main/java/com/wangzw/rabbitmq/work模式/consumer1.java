package com.wangzw.rabbitmq.work模式;

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
public class consumer1 {
    public static void main(String[] args) throws Exception{
        Connection connection = RabbitUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(1);//每次消费一条消息
        channel.queueDeclare("work",true,false,false,null);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(
                    String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                    byte[] body) throws IOException {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume("work",false,consumer);
    }
}
