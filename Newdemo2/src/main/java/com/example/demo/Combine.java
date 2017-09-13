package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Combine extends RouteBuilder {
 
    @Override
    public void configure() throws Exception {
    	from("file:D:\\one?noop=true")
		.convertBodyTo(String.class)
		.aggregate(simple("${file:ext} == 'txt'"), new MergeAggregationStrategy()) 
		.completionSize(2)
		.to("file:D:\\two"); 
  	}
    }