package com.example.demo;




import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Demo extends CamelSpringTestSupport  {

	/*@Test
	public void contextLoads() {
		File origPath = new File("/inputFolder/");
		File newPath = new File("/outputFolder/");
		for (File file : origPath.listFiles()) {
		    assertTrue(new File(newPath, file.getName()).exists());
		
		    }
		
}}*/
	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("camel-context.xml");
	}
	
	@Test
	public void testPayloadIsReached() 
	   throws InterruptedException {
	 MockEndpoint mockOut = getMockEndpoint("mock:out");
	 mockOut.setExpectedMessageCount(1);
	 template.sendBody("direct:in", "this is test");

	 assertMockEndpointsSatisfied();
	}
}