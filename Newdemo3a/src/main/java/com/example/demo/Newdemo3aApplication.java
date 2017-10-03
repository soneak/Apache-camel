package com.example.demo;



import org.apache.camel.CamelContext;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;



public class Newdemo3aApplication {

	public static void main(String[] args) throws Exception
		
		{
		    
		      
		        CamelContext context = new DefaultCamelContext();

		        context.addRoutes(new RouteBuilder() {

		            public void configure() throws Exception {
		                
		            
		        		
		        		from("rabbitmq://localhost:32780/reg?username=guest&password=guest&autoDelete=false&routingKey=key&queue=Que")
		                        .to("ftp://localhost:32781/home?username=bob&password=routr&disconnect=true");
		        		
		        	

		            }
		        });
		        context.start();
		        Thread.sleep(4000);
		       context.stop();
		      
		    }
		    
		    
		}