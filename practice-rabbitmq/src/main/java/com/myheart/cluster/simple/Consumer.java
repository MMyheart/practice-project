package com.myheart.cluster.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author yangxin
 * @date 2020/2/27
 */
public class Consumer {

    private String host;
    private int port;

    private String userName = "guest";
    private String passWord = "guest";

    private String queue;

    private Channel channel;
    private Connection connection;

    public Consumer(String host, int port, String queue) {
        this.host = host;
        this.port = port;
        this.queue = queue;
    }

    public void consumeOne() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(userName);
        factory.setPassword(passWord);

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();
        channel.basicQos(10);
//
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, Charset.forName("UTF-8"));
//                int result = 1 / 0;
                System.out.println("Received Message 【" + message + "】");
                channel.basicAck(envelope.getDeliveryTag(), false);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        channel.basicConsume(queue, false,
                (consumerTag, delivery) -> {

                    String message = new String(delivery.getBody(), Charset.forName("UTF-8"));
//                int result = 1 / 0;
                    System.out.println("Received Message 【" + message + "】");
                    channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                },
                consumerTag -> {
            System.out.println("调用"+consumerTag);
        });
//        channel.exchangeDeclare("cluster.same.exchange5","direct", true);
//        channel.queueDeclare("cluster.same.queue5", true, false, false, null);
//        channel.queueBind("cluster.same.queue5", "cluster.same.exchange5", "cluster.same.key5");
//        channel.close();
//        connection.close();
    }


    public void consumeOnesleep() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(userName);
        factory.setPassword(passWord);

        Connection connection = factory.newConnection();

        channel = connection.createChannel();
        channel.basicQos(1);
//
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, Charset.forName("UTF-8"));
//                int result = 1 / 0;
                System.out.println("Received Message 【" + message + "】");
                channel.basicAck(envelope.getDeliveryTag(), false);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        channel.basicConsume(queue, false, consumer);
//        channel.exchangeDeclare("cluster.same.exchange5","direct", true);
//        channel.queueDeclare("cluster.same.queue5", true, false, false, null);
//        channel.queueBind("cluster.same.queue5", "cluster.same.exchange5", "cluster.same.key5");
//        channel.close();
//        connection.close();
    }

    public void test(){
        try {
            channel.basicQos(50);
            System.out.println("test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
