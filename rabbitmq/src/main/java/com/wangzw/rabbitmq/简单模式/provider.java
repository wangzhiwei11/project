package com.wangzw.rabbitmq.简单模式;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
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
        channel.queueDeclare("hello",true,false,false,null);
        channel.basicPublish("","hello",null,"hello word".getBytes());
        channel.close();
        connection.close();
    }
}
