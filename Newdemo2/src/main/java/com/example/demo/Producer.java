package com.example.demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

	     public static final String QUEUE_NAME = "abc";
	     public static Connection connection;

	     public void setupConnection() throws IOException, TimeoutException {
	         ConnectionFactory factory = new ConnectionFactory();
	         factory.setHost("local");

	         connection = factory.newConnection();
	         Channel channel = connection.createChannel();
	         channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	     }
	}


