package com.java.aopdemo;
 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.java.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	public static void main(String[] args) {
		
		//read spring java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the AccountDAO bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Calling getFortune");
		String data = trafficFortuneService.getFortune();
		System.out.println("My fortune is: "+data);
		
		System.out.println("Finished!");
		
		//close the
		context.close();
	}
}
