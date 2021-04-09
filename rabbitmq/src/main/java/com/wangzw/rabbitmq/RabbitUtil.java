package com.wangzw.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <p>
 * </p>
 *
 * @author wangzw
 * @date 2021/4/9 10:45
 */
public class RabbitUtil {

    public static Connection getConnection(){
        Connection connection = null;
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("10.51.23.23");
            connectionFactory.setPort(5672);
            connectionFactory.setVirtualHost("/mall");
            connectionFactory.setUsername("mall");
            connectionFactory.setPassword("mall");
            connection = connectionFactory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
