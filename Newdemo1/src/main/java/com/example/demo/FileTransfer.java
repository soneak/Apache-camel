package com.example.demo;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
 
@Component
public class FileTransfer extends RouteBuilder {
 
    @Override
    public void configure() throws Exception {
    	
    	  from("file:D:\\Extension")
          .choice()
          .when()
          .simple("${file:ext} == 'xml'")
          .to("file:D:\\hi")
          .when()
          .simple("${file:ext} == 'csv'")
          .to("file:D:\\hello")
          .otherwise()
            .to("file:D:\\outbox");
    	
    	
    	

          /*  from("file:D://Extension")
            .choice()
            
            .validate(header("hello.xml").contains("hello.xml"))
            //.when(header.contains("hello.xml"))
            //.when(filename="hello.xml")
            
            .to("file:c://outbox")
           // .when(body().contains("hi.csv"))
            
           .validate(header("hi.csv").contains("hi.csv"))
            .to("file:c://inbox");
   */
    	
    	
    }
}