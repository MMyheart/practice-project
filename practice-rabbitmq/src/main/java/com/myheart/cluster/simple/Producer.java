package com.myheart.cluster.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author yangxin
 * @date 2020/2/27
 */
public class Producer {

    private String host;
    private int port;

    private String userName = "guest";
    private String passWord = "guest";

    private boolean available = false;
    private Channel channel;
    private Connection connection;

    private String exchange;
    private String routingKey;

    public Producer(String host, int port, String exchange, String routingkey){
        this.host = host;
        this.port = port;
        this.exchange = exchange;
        this.routingKey = routingkey;
    }

    public void Initialize() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(userName);
        factory.setPassword(passWord);

//        connection = factory.newConnection();
        connection = factory.newConnection(Address.parseAddresses(host));

        channel = connection.createChannel();

        available = true;
    }

    public void produce(String message) {
        if (available){
            AMQP.BasicProperties props = new AMQP.BasicProperties().builder()
                    .deliveryMode(2)
                    .build();
            try {
                channel.basicPublish(exchange, routingKey, props, message.getBytes(Charset.forName("UTF-8")));
            } catch (Exception e) {
                available = false;
                System.out.println("host = "+ host + ", port = "+port +", 连接断开！！！");
            }
            System.out.println("produce msg : "+ message);
        }
    }

    public void stop() throws Exception{
        available = false;
        channel.close();
        connection.close();
    }

}
