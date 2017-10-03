package com.example.demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


	
	 public class Producer {
	     public static final String QUEUE_NAME = "reg";
	     public static Connection connection;

	     public void setupConnection() throws IOException, TimeoutException {
		        ConnectionFactory factory = new ConnectionFactory();
		        factory.setHost("192.168.99.100");
		        factory.setUsername("guest");
		        factory.setPassword("guest");

		        connection = factory.newConnection();
		        Channel channel = connection.createChannel();
		        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		        channel.queueBind("reg", "amq.direct", "key");
		        //String message = "Hello World!";
		       // channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		        //System.out.println(" [x] Sent '" + message + "'");
		        channel.basicPublish("", QUEUE_NAME, null, null );
		    }
	
	}
	


