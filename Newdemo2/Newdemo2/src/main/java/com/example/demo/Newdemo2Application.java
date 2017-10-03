package com.example.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class Newdemo2Application {

	public static void main(String[] args)throws Exception {
		//SpringApplication.run(Newdemo2Application.class, args);

        Producer queueProd = new Producer();
        queueProd.setupConnection();
        System.out.println(queueProd.toString());

        CamelContext context = new DefaultCamelContext();//creating container

        context.addRoutes(new RouteBuilder() {
        	public void configure() throws Exception {
            	from("file:D:\\one?noop=true")
        		.convertBodyTo(String.class)
        		.aggregate(simple("${file:ext} == 'txt'"), new MergeAggregationStrategy()) 
        		.completionSize(2)
        		//.to("rabbitmq://localhost:5672/amq.direct");
        		//.to("rabbitmq://localhost:5672/amq.direct?username=guest&password=guest&autoDelete=false&queue=reg");
            	.to("rabbitmq://localhost:5672/amq.direct?username=guest&password=guest&autoDelete=false&routingKey=key&queue=reg");
               
        		//.to("file:D:\\two");
        	}
        });
        
        context.start();
        Thread.sleep(4000);
        context.stop();
    }
	}

